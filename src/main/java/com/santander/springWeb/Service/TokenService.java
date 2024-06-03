package com.santander.springWeb.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.santander.springWeb.DTO.LoginDTO;
import com.santander.springWeb.Handler.BusinessException;
import com.santander.springWeb.Models.User;
import com.santander.springWeb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    private UserRepo userRepo;

    @Value("${api.spring.security.jwt.secret}")
    private String secret;

    public String generate(@RequestBody String email) throws BusinessException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            UserDetails u = userRepo.findByEmail(email);
            return JWT.create().withIssuer("travel-app").withSubject(u.getUsername()).withExpiresAt(exp()).sign(algorithm);
        } catch (JWTCreationException e) {
            throw new BusinessException(e.getMessage());
        }
    }

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


