package br.com.alura.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.util.Locale;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSpringDataWebSupport
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);

    }

}
