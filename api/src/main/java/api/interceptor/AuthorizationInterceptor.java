package api.interceptor;

import api.auth.AuthorizationService;
import api.request.Header;
import api.request.RequestContext;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;

/**
 *  验签
 * @author max.hu  @date 2021-10-22
 **/
@Slf4j
//@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    private AuthorizationService authorizationService;

    public AuthorizationInterceptor(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DecodedJWT jwt = authorizationService.checkCredential(request);
        // 如果带jwt签名，就从jwt签名中补充一些信息 TODO
        if (null != jwt) {
            Header header = RequestContext.getContext();
            if (null != header) {
                header.setToken(jwt.getToken());
                Map<String, Object> userMap = jwt.getClaim("userInfo").asMap();
                if (userMap != null) {
                    header.setUserId(Long.valueOf(userMap.get("userId").toString()));
                }
                // 先判断再写入orgId
//            header.setOrgId(jwt.getClaim("orgId").asLong());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
