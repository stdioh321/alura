package br.com.alura.forum.seeder;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class Seeder {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @EventListener
//    public void seedUsuario() {
//        if (true == false && usuarioRepository.count() < 1){
//            Usuario user1 = new Usuario();
//            user1.setNome("Mario");
//            user1.setEmail("mario@test.com");
//            user1.setPerfis(new ArrayList<>());
//            user1.setSenha(new BCryptPasswordEncoder().encode("123456"));
//            Usuario user2 = new Usuario();
//            user2.setNome("Aluno");
//            user2.setEmail("aluno@test.com");
//            user2.setPerfis(new ArrayList<>());
//            user2.setSenha(new BCryptPasswordEncoder().encode("123456"));
//
//            usuarioRepository.save(user1);
//            usuarioRepository.save(user2);
//
//
//        }
//    }
}
