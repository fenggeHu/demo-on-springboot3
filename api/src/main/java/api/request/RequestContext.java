package api.request;

/**
 *  请求上下文
 * @author max.hu  @date 2021-10-22
 **/
public class RequestContext {
    private static ThreadLocal<Header> contextThreadLocal = new ThreadLocal<>();

    public static final Header getContext() {
        return contextThreadLocal.get();
    }

    public static final void setContext(Header h) {
        contextThreadLocal.set(h);
    }

    public static final void clear() {
        contextThreadLocal.remove();
    }

    public static String getLanguage() {
        return getContext().getLanguage();
    }

}
