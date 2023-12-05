package api.utils;

import api.request.RequestConstants;
import api.request.Header;
import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import com.google.common.net.InetAddresses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Request Utils
 *
 * @author max.hu  @date 2021-10-22
 */
@Slf4j
public class RequestUtil {
    private final static String X_REAL_IP = "X-Real-IP";

    public final static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader(HttpHeaders.X_FORWARDED_FOR);
        if (!Strings.isNullOrEmpty(ip)) {
            if (log.isInfoEnabled()) {
                log.info("Request[{}] X_FORWARDED_FOR:{}", request.getRequestURI(), ip);
            }
            // 多个ip 取第一个
            if (ip.contains(",")) {
                ip = ip.split(",")[0].trim();
            }
            if (!Strings.isNullOrEmpty(ip) && InetAddresses.isInetAddress(ip)) {
                return ip;
            }
        }
        // X_REAL_IP
        String rip = request.getHeader(X_REAL_IP);
        if (log.isInfoEnabled()) {
            log.info("request[{}] X-Real-IP:{}", request.getRequestURI(), Strings.nullToEmpty(rip));
        }
        if (!Strings.isNullOrEmpty(rip) && InetAddresses.isInetAddress(rip)) {
            return rip;
        }
        // Remote Address
        if (log.isInfoEnabled()) {
            log.info("request[{}] RemoteAddress:{}", request.getRequestURI(), request.getRemoteAddr());
        }
        return request.getRemoteAddr();
    }

    /**
     * Private IP地址，通常又被称为RFC1918地址，是按照IETF RFC 1918，被公司或组织在其自有的网络中为非公开目的而使用的地址。由于不能通过路由器传输，Private IP地址不能被直接与互联网相连接。
     * 范围：
     * A class: 10.0.0.0 ~ 10.255.255.255
     * B class: 172.16.0.0 ~ 172.31.255.255
     * C class: 192.168.0.0 ~ 192.168.255.255
     */
    public final static boolean isPrivateIp(String ip) {
        if (ip.equals("127.0.0.1") || ip.substring(0, 3) == "10." || ip.substring(0, 7) == "192.168") {
            return true;
        } else if (ip.substring(0, 4) == "172.") {
            String[] sa = ip.split("\\.");
            int si = Integer.parseInt(sa[1]);
            if (si >= 16 && si <= 31) {
                return true;
            }
        }

        return false;
    }

    public final static Header getHeader(HttpServletRequest request) {
        String token = CookieUtil.getValue(request, RequestConstants.TOKEN);
        if (Strings.isNullOrEmpty(token)) {
            token = request.getParameter(RequestConstants.TOKEN);
        }
        String sessionId = CookieUtil.getValue(request, RequestConstants.SESSION_ID);
        if (Strings.isNullOrEmpty(sessionId)) {
            sessionId = request.getParameter(RequestConstants.SESSION_ID);
        }
        long timestamp = 0;
        String ts = request.getParameter(RequestConstants.TIMESTAMP);
        if (!Strings.isNullOrEmpty(ts)) {
            timestamp = Long.parseLong(ts);
        }

        return Header.builder()
                .serverName(request.getServerName())
                .serverUri(request.getRequestURI())
                .remoteIp(getRemoteIp(request))
                .userAgent(Strings.nullToEmpty(request.getHeader(HttpHeaders.USER_AGENT)))
                .referer(Strings.nullToEmpty(request.getHeader(HttpHeaders.REFERER)))
//                .sessionId(Strings.nullToEmpty(sessionId))
                .token(Strings.nullToEmpty(token))
//                .orgId(orgId)
                .uncheckedUserId(Strings.nullToEmpty(request.getHeader(RequestConstants.USER_ID)))
                .language(LocaleContextHolder.getLocale().toString())
                .timestamp(timestamp)
                .requestTime(System.currentTimeMillis())
                .authorization(request.getHeader(HttpHeaders.AUTHORIZATION))
                .build();
    }
}


