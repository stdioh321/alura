package br.com.alura.forum.config;


import br.com.alura.forum.config.filter.LocaleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LocaleFilter localeFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*super.configure(http);*/
        http
                .csrf().disable()
                .addFilter(localeFilter);

    }
}