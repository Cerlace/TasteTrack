package cerlace.tastetrack.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final long DAYS_TO_STORE_COOKIE = 365L;

    /**
     * Создает и настраивает бин {@link MessageSource} для загрузки сообщений из файлов ресурсов.
     * Сообщения загружаются из файлов, расположенных в classpath с базовым именем "messages".
     *
     * @return настроенный {@link ReloadableResourceBundleMessageSource}.
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("classpath:messages");
        return messageSource;
    }

    /**
     * Создает и настраивает бин {@link LocaleResolver} для определения локали пользователя.
     * Используется {@link CookieLocaleResolver}, который хранит выбранную локаль в cookies.
     * По умолчанию устанавливается локаль "ru".
     *
     * @return настроенный {@link CookieLocaleResolver}.
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setCookieMaxAge(Duration.ofDays(DAYS_TO_STORE_COOKIE));
        cookieLocaleResolver.setDefaultLocale(Locale.forLanguageTag("ru"));
        return cookieLocaleResolver;
    }

    /**
     * Создает и настраивает бин {@link LocaleChangeInterceptor} для изменения локали
     * на основе параметра запроса. По умолчанию параметр запроса для изменения локали — "lang".
     *
     * @return настроенный {@link LocaleChangeInterceptor}.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
