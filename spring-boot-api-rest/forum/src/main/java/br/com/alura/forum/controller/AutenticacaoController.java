package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.JwtDto;
import br.com.alura.forum.controller.dto.UsuarioDto;
import br.com.alura.forum.modelo.LoginForm;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import br.com.alura.forum.service.JwtTokenUtil;
import br.com.alura.forum.service.TokenService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/auth")
    public ResponseEntity<JwtDto> autenticar(@RequestBody @Valid LoginForm loginForm, HttpServletRequest req) {
        Authentication auth = null;
        JwtDto jwtDto = null;
        try {
            UsernamePasswordAuthenticationToken dadosLogin = loginForm.toUsernamePasswordAuthenticationToken();
            auth = authManager.authenticate(dadosLogin);
            Usuario user = ((Usuario) auth.getPrincipal());
            String token = jwtTokenUtil.doGenerateToken(user, req);
            jwtDto = new JwtDto(token, "Bearer", new UsuarioDto(user));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok(jwtDto);
    }


    @GetMapping("/me")
//    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer [access_token]")
    public ResponseEntity<UsuarioDto> me() {
        var username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var user = usuarioRepository.findByEmailIgnoreCase(username);
        if (user.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(new UsuarioDto(user.get()));
    }
}
