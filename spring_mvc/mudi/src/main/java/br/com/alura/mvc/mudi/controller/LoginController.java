package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class LoginController {
//    @Autowired
//    private AuthenticationManager authManager;

    @GetMapping
    @RequestMapping("/login")
    public String login(LoginForm loginForm) {
        return "login";
    }

//    @PostMapping(value = "/my-login")
//    public String doLogin(@Valid LoginForm loginForm, BindingResult result) {
//        if (result.hasErrors()) {
//            return "login";
//        }
//        Authentication auth = null;
//        try {
//            var userPassAuth = new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
//            auth = authManager.authenticate(userPassAuth);
//            var user = (UserDetails) auth.getPrincipal();
//            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(userAuth);
//            return "redirect:/usuario/pedido";
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return "login";
//        }
//    }
}
