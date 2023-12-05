package api.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author max.hu  @date 2021-10-22
 **/
@Data
@Configuration
public class RestApiProperties {
    /**
     * Request拦截器 - 读取header信息
     */
    @Value("${api.interceptor.header.enable:true}")
    private boolean headerInterceptorEnable;
    @Value("${api.interceptor.header.path:}")
    private String[] headerPathPatterns;
    @Value("${api.interceptor.header.excludePath:}")
    private String[] headerExcludePathPatterns;

    /**
     * Session拦截器 - 读取session信息
     */
    @Value("${api.interceptor.session.enable:true}")
    private boolean sessionInterceptorEnable;
    @Value("${api.interceptor.session.path:}")
    private String[] sessionPathPatterns;
    @Value("${api.interceptor.session.excludePath:}")
    private String[] sessionExcludePathPatterns;

    /**
     * 启用权限控制 - 对应PermissionAspect.class
     */
    @Value("${api.permission.enable:false}")
    private boolean permissionEnable;

    /**
     * 启用authorization
     */
    @Value("${api.authorization.enable:false}")
    private boolean authorizationEnable;
    @Value("${api.authorization.type:}")
    private String authorizationType;
    @Value("${api.authorization.scheme:}")
    private String authorizationScheme;

    /**
     * cookie配置
     */
    @Value("${api.cookie.secure:false}")
    private boolean cookieSecure;
    @Value("${api.cookie.domain:}")
    private String cookieDomain;

    /**
     * API路径
     * - 使用 AdminResponseBodyAdvice
     */
    @Value("${api.path.startWith:}")
    private String[] pathStartWith;

}
