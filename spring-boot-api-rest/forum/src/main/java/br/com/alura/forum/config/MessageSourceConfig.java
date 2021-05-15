package br.com.alura.forum.config;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageSourceConfig {


    @Value("${defaultlang}")
    private String lang = "en_US";

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(LocaleUtils.toLocale(lang));

        return messageSource;
    }


    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());

        return bean;
    }


    @Bean
    public LocaleResolver localeResolver() {

        /*var localeResolver = new AcceptHeaderLocaleResolver();*/
        var localeResolver = new CookieLocaleResolver();
        Locale locale;
        locale = LocaleUtils.toLocale(lang);

        localeResolver.setDefaultLocale(locale);

        return localeResolver;
/*
        var sess = new SessionLocaleResolver();
        sess.setDefaultLocale(Locale.FRANCE);
        return sess;*/

    }

    /*@Bean
    public MessageSourceAccessor messageSourceAccessor() {
        return new MessageSourceAccessor(messageSource(),Locale.US);
    }*/


}
