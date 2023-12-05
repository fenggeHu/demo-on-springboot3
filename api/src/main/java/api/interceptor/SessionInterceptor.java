package api.interceptor;

import api.auth.SessionInfo;
import api.auth.SessionProvider;
import api.request.Header;
import api.request.RequestContext;
import api.utils.SpringContextUtil;
import com.google.common.base.Strings;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: 请求头、一些通用信息
 * @author max.hu  @date 2021-10-22
 **/
@Slf4j
//@Order(0)
//@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Header header = RequestContext.getContext();
        this.loadSession(header);

        return true;
    }

    /**
     * session 信息 - 要排除登录，否则可能拿到上一个sessionId
     *
     * @param header
     */
    private void loadSession(final Header header) {
        if (Strings.isNullOrEmpty(header.getSessionId())) return;

        SessionProvider sessionProvider = SpringContextUtil.getBean(SessionProvider.class);
        SessionInfo sessionInfo = sessionProvider.getSession(header.getSessionId());
        if (null == sessionInfo) return;
        header.setSession(sessionInfo);
        header.setUserId(sessionInfo.getId());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
