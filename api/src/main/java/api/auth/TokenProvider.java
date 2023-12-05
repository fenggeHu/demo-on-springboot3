package api.auth;

/**
 * @description: token生成、验证
 * @author max.hu  @date 2021-11-12
 **/
public interface TokenProvider {
    /**
     * 生成token
     * @param issuer
     * @param subject
     * @return
     */
    String generateToken(String issuer, String subject);

    Object parseToken(String token);
}
