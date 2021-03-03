package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UsuarioPostForm implements IBasicForm<Usuario> {
    @NotNull
    @NotBlank
    @Length(min = 2)
    private String nome;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "{usuario.senha.pattern}")
    private String senha;


    @Override
    public <UsuarioRepository extends JpaRepository> Usuario convert(UsuarioRepository respository) {
        return null;
    }

    @Override
    public Usuario convert() {
        Usuario usu = new Usuario();
        usu.setNome(nome);
        usu.setEmail(email);
        usu.setSenha(senha);
        return usu;
    }


    public Usuario update(Long id, UsuarioRepository usuarioRepository) {
        var usuario = usuarioRepository.getOne(id);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }
}
