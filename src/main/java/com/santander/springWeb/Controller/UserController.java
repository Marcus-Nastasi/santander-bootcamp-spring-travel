package com.santander.springWeb.Controller;

import com.santander.springWeb.Models.User;
import com.santander.springWeb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String hello() {
        return "Welcome to the application!";
    }

    @GetMapping(value = "/api/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/api/users/${id}")
    public User singleUser(@PathVariable("id") int id) {
        return userRepo.findById(id).get();
    }
}


