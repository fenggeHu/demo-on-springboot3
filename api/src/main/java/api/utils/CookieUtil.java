package api.utils;

import com.google.common.base.Strings;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Cookie util
 *
 * @author max.hu  @date 2021-10-22
 */
public class CookieUtil {

    /**
     * 构建Cookie
     *
     * @param domain
     * @param name
     * @param value
     * @param ages
     * @param secure
     * @param httpOnly
     * @return
     */
    public static Cookie build(String name, String value, int ages, String domain, boolean secure, boolean httpOnly) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);   //secure=true => work on HTTPS only.
        cookie.setHttpOnly(httpOnly);   //invisible to JavaScript.
        if (!Strings.isNullOrEmpty(domain)) {
            cookie.setDomain(domain);    //visible to domain only
        }
//        cookie.setDomain(domain.replaceAll("(^[.]+)", ""));
        cookie.setMaxAge(ages);     //maxAge=0: expire cookie now, maxAge<0: expire cookie on browser exit.
        cookie.setPath("/");
        return cookie;
    }

    public static void create(HttpServletResponse response, String name, String value,
                              int ages, String domain, boolean secure, boolean httpOnly, String path) {
        Cookie cookie = build(name, value, ages, domain, secure, httpOnly);
        if (Strings.isNullOrEmpty(path)) {
            path = "/";
        }
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    /**
     * 删除Cookie
     *
     * @param response
     * @param name
     * @param secure
     * @param httpOnly
     * @param path
     */
    public static void clear(HttpServletResponse response, String name, String domain, boolean secure, boolean httpOnly, String path) {
        Cookie cookie = new Cookie(name, null);
        cookie.setSecure(secure);
        cookie.setHttpOnly(httpOnly);
        cookie.setMaxAge(0);
        if (Strings.isNullOrEmpty(path)) {
            path = "/";
        }
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    public static void clear(HttpServletResponse response, String name, String domain) {
        Cookie cookie = new Cookie(name, null);
        if (!Strings.isNullOrEmpty(domain)) {
            cookie.setDomain(domain);    //visible to domain only
//        cookie.setDomain(domain.replaceAll("(^[.]+)", ""));
        }
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static String getValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}


