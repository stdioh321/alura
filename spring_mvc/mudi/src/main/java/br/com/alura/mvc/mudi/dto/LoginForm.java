package br.com.alura.mvc.mudi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    @NotBlank
    @Length(min = 2)
    private String username;

    @NotBlank
    @Length(min = 2)
    private String password;

}
