package api.locale;

import api.locale.LocaleConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import java.util.Locale;

/**
 * @author max.hu  @date 2023/11/29
 **/
public class LocaleUtil {

    private final static String SEP = "_";

    public static String getLanguage(Locale locale) {
        return locale.getLanguage() + (StringUtils.isNotEmpty(locale.getCountry()) ? SEP + locale.getCountry() : "");
    }

    public static String getLanguage() {
        Locale locale = LocaleContextHolder.getLocale();
        return getLanguage(locale != null ? locale : LocaleConfig.DEFAULT_LOCAL);
    }

}
