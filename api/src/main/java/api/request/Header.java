package api.request;

import api.auth.SessionInfo;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 请求头/通用信息
 */
@Builder
@Data
public class Header implements Serializable {
    private static final long serialVersionUID = 5886491125925627264L;
    /**
     * token 用户身份 - 服务下发，如SSO
     */
    private String token;
    /**
     * session Id
     */
    private String sessionId;
    /**
     * 服务端验证后的用户ID
     */
    private Long userId;
    /**
     * language value
     */
    private String language;
    /**
     * 客户端发起请求的时间
     */
    private Long timestamp;
    /**
     * 请求到达服务端的时间
     */
    private final Long requestTime;
    /**
     * 保留请求签名 - signed with the API secret key and the RS256
     * 参考 https://swagger.io/docs/specification/authentication/bearer-authentication/
     */
    private final String authorization;

    /**
     * header 部分
     */
    private String serverName;
    private String serverUri;
    private String remoteIp;
    private String userAgent;
    private String referer;
    /**
     * 客户端传入的用户ID
     */
    private String uncheckedUserId;

    /**
     * session信息
     */
    private SessionInfo session;
}
