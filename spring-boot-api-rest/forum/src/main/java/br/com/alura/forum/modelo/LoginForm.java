package br.com.alura.forum.modelo;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginForm {
    @NotNull
    @NotBlank
    @Length(min = 2)
    private String username;

    @NotNull
    @NotBlank
    @Length(min = 2)
    private String password;


    public UsernamePasswordAuthenticationToken toUsernamePasswordAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(getUsername(), getPassword());
    }
}
