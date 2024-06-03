package com.santander.springWeb.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.santander.springWeb.DTO.LoginDTO;
import com.santander.springWeb.Handler.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TokenService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${api.spring.security.jwt.secret}")
    private String secret;

    @Bean
    public String generate(@RequestBody LoginDTO login) throws BusinessException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("travel-app").withSubject(login.email()).withExpiresAt(exp()).sign(algorithm);
        } catch (JWTCreationException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Bean
    public String valid(String token) throws BusinessException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("travel-app").build().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    private Instant exp() {
        return LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00"));
    }
}


