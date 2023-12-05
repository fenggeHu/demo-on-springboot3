package api.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: spring bean 操作类
 * @author max.hu  @date 2021-11-12
 **/
@Component
public class SpringContextUtil implements ApplicationContextAware {
    // Spring应用上下文环境
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
        if (applicationContext == null) {
            SpringContextUtil.applicationContext = _applicationContext;
        }
    }

    /**
     * 通过bean name 获取对象
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 通过bean类型获取对象
     */
    public static <T> T getBean(Class<T> clz) {
        return applicationContext.getBean(clz);
    }

    /**
     * 通过bean类型返回所有实例。 - 如，通过接口返回所有的实现类实例。
     */
    public static <T> Map<String, T> getBeansOfType(@Nullable Class<T> type) {
        return applicationContext.getBeansOfType(type);
    }
}
