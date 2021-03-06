package br.com.alura.forum.config.filter;

import org.apache.commons.lang3.LocaleUtils;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;


@Component
public class LocaleFilter extends OncePerRequestFilter {
    @Autowired
    private LocaleResolver localeResolver;

    @Value("${defaultlang}")
    private String defaultLang;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("doFilterInternal LocaleFilter");
        System.out.println(LocaleContextHolder.getLocale());
        var lang = request.getHeader("Accept-Language");
        var contextLocale = LocaleContextHolder.getLocale();
        try {
            if (StringUtils.isNullOrEmpty(lang)) throw new RuntimeException("No Accept-Language");
            var l = request.getLocale();
            localeResolver.setLocale(request, response, l);
        } catch (Exception ex) {
            localeResolver.setLocale(request, response, LocaleUtils.toLocale(defaultLang));
        }


        /*localeResolver.setLocale(request, response, new Locale("es"));*/
        filterChain.doFilter(request, response);
    }
}