package br.com.alura.forum.config.filter;

import br.com.alura.forum.modelo.JwtBlacklist;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.JwtBlacklistRepository;
import br.com.alura.forum.repository.UsuarioRepository;
import br.com.alura.forum.service.JwtTokenUtil;
import br.com.alura.forum.service.TokenService;
import io.jsonwebtoken.ExpiredJwtException;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Component
public class AuthJwtFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtBlacklistRepository jwtBlacklistRepository;

    @Value("${jwt.allowedTimeAfterExpirartion}")
    private Long allowedTimeAfterExpirartion;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        return super.shouldNotFilter(request);
        System.out.println(request.getRequestURI());
        return request.getRequestURI().startsWith("/h2-console");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String jwt = getToken(request);

        try {
            String username = jwtTokenUtil.getUsernameFromToken(jwt);
            Boolean isValid = jwtTokenUtil.isTokenValid(jwt);
            if (!StringUtils.isNullOrEmpty(username) && isValid == true) {
                authenticateUser(jwt);
            }
        } catch (ExpiredJwtException ex1) {
            try {
                var userId = Long.parseLong(ex1.getClaims().getSubject());
                var exp = ex1.getClaims().getExpiration();
                var afterExpiration = Date.from(exp.toInstant().plusMillis(allowedTimeAfterExpirartion));

                if (exp.after(afterExpiration)) throw new RuntimeException("Passed too much time after expired.");

                if (jwtBlacklistRepository.existsByName(jwt)) throw new RuntimeException("Token is blacklisted.");

                Optional<Usuario> user = usuarioRepository.findById(userId);
                if (user.isPresent()) {
                    String token = jwtTokenUtil.doGenerateToken(user.get(), request);
                    response.addHeader("Refresh-Token", token);
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user.get().getEmail(), null, user.get().getPerfis());
                    SecurityContextHolder.getContext().setAuthentication(auth);

                    JwtBlacklist tokenToBlacklist = new JwtBlacklist();
                    tokenToBlacklist.setName(jwt);

                    jwtBlacklistRepository.save(tokenToBlacklist);
                }
            } catch (Exception ex2) {
//                ex2.printStackTrace();
            }

        } catch (Exception ex) {
//            ex.printStackTrace();
        }
        chain.doFilter(request, response);
    }

    private void authenticateUser(String jwt) {
        Long userId = Long.parseLong(jwtTokenUtil.getUsernameFromToken(jwt));
        Optional<Usuario> user = usuarioRepository.findById(userId);
        if (user.isPresent()) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user.get().getEmail(), null, user.get().getPerfis());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.isNullOrEmpty(token) || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7);
    }


}
