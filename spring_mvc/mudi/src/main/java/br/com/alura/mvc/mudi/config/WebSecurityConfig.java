package br.com.alura.mvc.mudi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AutenticacaoService autenticacaoService;

    @Autowired
    private DataSource dataSource;
//
//    @Bean
//    public PasswordEncoder defaultPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home/**", "/tmp", "/my-login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/usuario/pedido", true)
                        .permitAll()
                )
                .logout(logout -> {
                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/home");
                }).csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.userDetailsService(autenticacaoService).passwordEncoder(defaultPasswordEncoder());

        var user =
                User.builder()
                        .username("john")
                        .password(new BCryptPasswordEncoder().encode("john"))
                        .roles()
                        .build();

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .withUser(
                        User
                                .withUsername("maria")
                                .password("maria")
                                .roles("USER")
                )
                .withUser(
                        User
                                .withUsername("john")
                                .password("john")
                                .roles("ADMIN")
                )
                .passwordEncoder(new BCryptPasswordEncoder());


//        JdbcUserDetailsManagerConfigurer auth2 = auth
//
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(encoder);

//        auth2.withUser(user);

    }

}
