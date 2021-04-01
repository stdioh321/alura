package br.com.stdioh.testes.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@Builder(builderMethodName = "hiddenBuilder")
public class User {

    private String id;
    private String name;
    private String email;


    public static UserBuilder builder() {
        return hiddenBuilder().id(UUID.randomUUID().toString());
    }


}
