package api.auth;

/**
 * 用户登录接口
 *
 * @author max.hu  @date 2023/11/30
 **/
public interface IUserLoginService {
    SessionInfo login(String username, String password);

    void loginOut(SessionInfo sessionInfo);
}
