package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.LoginForm;
import br.com.alura.forum.modelo.Perfil;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.PerfilRepository;
import br.com.alura.forum.repository.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
class AutenticacaoControllerTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;


    @Autowired
    private MockMvc mock;


    public Usuario addUser() {
        Perfil perfil = new Perfil(null, "ROLE_ALUNO");
        perfilRepository.save(perfil);

        Usuario usuario = new Usuario();
        usuario.setNome("aluno");
        usuario.setEmail("aluno@test.com");
        usuario.setSenha(new BCryptPasswordEncoder().encode("123456"));
        usuario.setPerfis(new ArrayList<>() {{
            add(perfil);
        }});

        return usuarioRepository.save(usuario);
    }

    @Test
    public void deveriaRetornar400ComCredenciaisInvalidas() throws Exception {
        URI uri = new URI("/auth");
        ObjectMapper objectMapper = new ObjectMapper();
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("aluno");
        loginForm.setPassword("123");
        String json = objectMapper.writeValueAsString(loginForm);

        mock.perform(
                MockMvcRequestBuilders.post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(HttpStatus.BAD_REQUEST.value()));

    }

    @Test
    public void deveriaRetornar400CredenciaisInvalidas() throws Exception {
        Usuario user = addUser();

        URI uri = new URI("/auth");
        ObjectMapper objectMapper = new ObjectMapper();
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("alunos@test.com");
        loginForm.setPassword("123456");
        String json = objectMapper.writeValueAsString(loginForm);

        mock.perform(
                MockMvcRequestBuilders.post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(HttpStatus.BAD_REQUEST.value()));

    }

    @Test
    public void deveriaRetornar200ComToken() throws Exception {
        Usuario user = addUser();

        URI uri = new URI("/auth");
        ObjectMapper objectMapper = new ObjectMapper();
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("aluno@test.com");
        loginForm.setPassword("123456");
        String json = objectMapper.writeValueAsString(loginForm);

        mock.perform(
                MockMvcRequestBuilders.post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers
                .status()
                .is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.jwt").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").exists());

    }
}
