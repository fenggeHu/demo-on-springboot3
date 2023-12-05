package api.auth;

import api.config.RestApiProperties;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import common.exception.BizException;
import common.exception.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  身份识别 - jwt - 需要子类实现验签算法
 * https://developer.mozilla.org/en-US/docs/Web/HTTP/Authentication
 * @author max.hu  @date 2021-11-02
 **/
@Slf4j
public abstract class AuthorizationService {
    @Autowired
    private RestApiProperties restApiProperties;

    /**
     * app key - jwt解签算法 - 需要子类实现
     */
    public Algorithm getAlgorithm(String apiKey) {
        throw new RuntimeException("need override");
    }

    /**
     * 验签
     */
    public DecodedJWT checkCredential(HttpServletRequest request) {
        // 不需要验签
        if (!restApiProperties.isAuthorizationEnable()) {
            return null;
        }

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (Strings.isNullOrEmpty(auth)) {
            throw new BizException(ErrorCode.UNAUTHORIZED);
        }
        if (!auth.startsWith(restApiProperties.getAuthorizationScheme())) {
            throw new BizException(ErrorCode.UNAUTHORIZED, "scheme not match");
        }
        String token = auth.substring(restApiProperties.getAuthorizationScheme().length());

        return verifyJwt(token);
    }

    /**
     * jwt
     */
    private DecodedJWT verifyJwt(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String apiKey = jwt.getSubject();
        Algorithm algorithm = getAlgorithm(apiKey);
        // 验签
        try {
            algorithm.verify(jwt);
        } catch (SignatureVerificationException s) {
            // 验签失败
            throw new BizException(ErrorCode.UNAUTHORIZED, "invalid token");
        } catch (Exception e) {
            log.error("verifyJwt", e);
            // 其它错误
            throw new BizException(ErrorCode.ERROR, e.getMessage());
        }
        return jwt;
    }
}
