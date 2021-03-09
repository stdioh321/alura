package br.com.alura.forum.service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    @Value("${jwt.secret}")
    private String SIGNING_KEY;

    @Value("${jwt.expiration}")
    private String ACCESS_TOKEN_VALIDITY_MILI;


    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

//    public String generateToken(Usuario user) {
//        return doGenerateToken(user.getUsername());
//    }

    public String doGenerateToken(Usuario usuario) {
        return doGenerateToken(usuario, null);
    }

    public String doGenerateToken(Usuario usuario, HttpServletRequest request) {

        Claims claims = Jwts.claims().setSubject(usuario.getId().toString());
        if (!Objects.isNull(request)) {
            claims.putIfAbsent("ip", request.getRemoteAddr());
            claims.putIfAbsent("user-agent", request.getHeader("User-Agent"));
        }
//        claims.put("roles", usuario.getAuthorities().stream().map(tmp -> tmp.getAuthority()).collect(Collectors.toList()));
        claims.put("roles", usuario.getAuthorities());
        Date issuedAt = Date.from(Instant.now());
        Date expiration = Date.from(Instant.now().plusMillis(Long.parseLong(ACCESS_TOKEN_VALIDITY_MILI)));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("ALURA")
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (
                username.equals(userDetails.getUsername())
                        && !isTokenExpired(token));
    }

    public Boolean isTokenValid(String token) {
        try {
            var claims = getAllClaimsFromToken(token);
            return true;
        } catch (Exception ex) {

        }
        return false;
    }

}