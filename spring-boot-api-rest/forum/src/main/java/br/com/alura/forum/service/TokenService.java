package br.com.alura.forum.service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expirationMili;

    @Value("${jwt.secret}")
    private String secret;


    public String generateToken(Authentication auth, HttpServletRequest req) {
        Usuario user = (Usuario) auth.getPrincipal();
        Date issuer = Date.from(Instant.now());
        Date expiration = Date.from(Instant.now().plusMillis(Long.parseLong(expirationMili)));
        Map claims = new HashMap<String, Object>();
        claims.putIfAbsent("ip", req.getRemoteAddr());
        claims.putIfAbsent("user-agent", req.getHeader("User-Agent"));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("API do Forum da Alura")
                .setIssuedAt(issuer)
                .setExpiration(expiration)
                .setSubject(user.getId().toString())

                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public boolean isValid(String jwt) {
        try {
            var claims = getAllClaimsFromToken(jwt);

            return true;
        } catch (Exception ex) {

        }
        return false;
    }



    public Claims getAllClaimsFromToken(String token) {
        Claims claims = null;
        claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims;
    }


    public Long getIdUser(String jwt) {
        return Long.parseLong(getAllClaimsFromToken(jwt).getSubject());
    }
}
