package api.auth;

import api.utils.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Cookie操作
 * @author max.hu  @date 2021-11-12
 */
public class CookieProvider {
    private String domain;
    private boolean secure;
    private String path = "/";

    public CookieProvider(String domain, boolean secure) {
        this.domain = domain;
        this.secure = secure;
    }

    public void create(HttpServletResponse response, String name, String value, boolean httpOnly) {
        Cookie cookie = CookieUtil.build(name, value, -1, domain, secure, httpOnly);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    public void clear(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath(path);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}


