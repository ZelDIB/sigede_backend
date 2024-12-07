package mx.edu.utez.sigede_backend.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.sigede_backend.models.user_account.UserAccount;
import mx.edu.utez.sigede_backend.security.AuthenticationProcessingException;
import mx.edu.utez.sigede_backend.security.config.TokenJwtConfig;
import mx.edu.utez.sigede_backend.security.model.AuthDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.*;

import static mx.edu.utez.sigede_backend.security.config.TokenJwtConfig.*;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final TokenJwtConfig tokenJwtConfig;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, TokenJwtConfig tokenJwtConfig) {
        this.authenticationManager = authenticationManager;
        this.tokenJwtConfig = tokenJwtConfig;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UserAccount user;
        String username;
        String password;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), UserAccount.class);
            username= user.getEmail();
            password = user.getPassword();

        } catch (IOException e) {
            throw new AuthenticationProcessingException("Error al procesar la autenticación", e);
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authToken);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        AuthDetails user = (AuthDetails) authResult.getPrincipal();
        String username= user.getEmail();
        Collection<? extends GrantedAuthority> roles = user.getAuthorities();
        Long institutionId = user.getInstitutionId();
        Long userId = user.getUserId();

        Claims claims = Jwts.claims();
        claims.put("authorities",new ObjectMapper().writeValueAsString(roles));


        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .signWith(tokenJwtConfig.getSecretKey())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+3600000))
                .compact();
        response.addHeader(HEADER_AUTHORIZATION,PREFIX_TOKEN + token);

        Map<String,Object> body = new HashMap<>();
        body.put("token",token);
        body.put("email",username);
        if (institutionId != null) {
            body.put("institutionId", institutionId);
        }
        body.put("userId",userId);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(CONTENT_TYPE);

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        Map<String ,Object> body= new HashMap<>();
        body.put("messsage","Error en la autenticacion username o password es incorrecto");
        body.put("error",failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType(CONTENT_TYPE);

    }
}
