package api.locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

/***
 * @description: 本地语言包
 * @author fengge.hu
 * @author max.hu  @date 2023/11/29
 */
@Configuration
public class LocaleConfig {

    public static Locale DEFAULT_LOCAL = Locale.US;

    @Bean
    public LocaleChangeInterceptor localeChange() {
        return new LocaleChangeInterceptor();
    }

    //与其它网站统一使用Accept-Language
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        //localeResolver.setSupportedLocales(Lists.newArrayList(Locale.US, Locale.CHINA));
        localeResolver.setDefaultLocale(DEFAULT_LOCAL);
        return localeResolver;
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("utf-8");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setBasename("classpath:language/messages");
        return messageSource;
    }

}
