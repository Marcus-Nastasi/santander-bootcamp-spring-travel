package com.santander.springWeb.Controller.Auth;

import com.santander.springWeb.DTO.LoginDTO;
import com.santander.springWeb.Handler.BusinessException;
import com.santander.springWeb.Repository.UserRepo;
import com.santander.springWeb.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        UserDetails u = userRepo.findByEmail(loginDTO.email());

        if (u == null) throw new BusinessException("null pointer on LoginDTO");

        if (passwordEncoder.matches(loginDTO.password(), u.getPassword())) {
            String token = tokenService.generate(u.getUsername());
            return ResponseEntity.accepted().body(token);
        }

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("wrong password");
    }
}



