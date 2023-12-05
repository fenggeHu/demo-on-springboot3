package api.request;

/**
 * @description: header info key
 * @author max.hu  @date 2021-10-22
 **/
public interface RequestConstants {
    /**
     *
     */
    String API_KEY = "X-API-Key";

    /**
     * 服务端下发的token - 客户端回传
     */
    String TOKEN = "token";
    /**
     * session id
     */
    String SESSION_ID = "sessionId";

    /**
     * 客户端发起请求的时间
     */
    String TIMESTAMP = "timestamp";

    /**
     * 机构id - 可能没有
     */
    String ORG_ID = "org_id";
    /**
     * 用户id - 可能没有
     */
    String USER_ID = "user_id";
}
