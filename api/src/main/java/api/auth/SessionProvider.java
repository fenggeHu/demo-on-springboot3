package api.auth;

/**
 * @description: session操作
 * @author max.hu  @date 2021-11-12
 **/
public interface SessionProvider {
    /**
     * 保存
     * @param sessionId
     * @param userInfo
     * @return
     */
    boolean putSession(String sessionId, SessionInfo userInfo);

    /**
     * 取session
     * @param sessionId
     * @return
     */
    SessionInfo getSession(String sessionId);
    /**
     * 清除session
     * @param sessionId
     * @return
     */
    boolean clearSession(String sessionId);
}
