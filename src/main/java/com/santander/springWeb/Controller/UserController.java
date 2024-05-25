package com.santander.springWeb.Controller;

import com.santander.springWeb.Models.User;
import com.santander.springWeb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/api/users/{id}")
    public User singleUser(@PathVariable("id") int id) {
        return userRepo.findById(id).get();
    }

    @PostMapping(value = "/api/users/add")
    public void insertUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @PutMapping(value = "/api/users/{id}/update")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        User uFinded = userRepo.findById(id).get();
        uFinded.update(user.getName(), user.getEmail(), user.getBirth());
        userRepo.save(uFinded);
    }

    @DeleteMapping(value = "/api/users/{id}/delete")
    public void deleteUser(@PathVariable("id") int id) {
        if(userRepo.findById(id).isPresent()) userRepo.deleteById(id);
    }
}



