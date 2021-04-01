package br.com.alura.leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Helpers {

    @Autowired
    private Environment environment;


    public String getBaseUrl() {
        return "http://localhost:" + getPort();
    }

    public String getPort() {
        return environment.getProperty("local.server.port");
    }
}