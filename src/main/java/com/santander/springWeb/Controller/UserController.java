package com.santander.springWeb.Controller;

import com.santander.springWeb.Handler.BusinessException;
import com.santander.springWeb.Models.User;
import com.santander.springWeb.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public String hello() {
        return "Welcome to the application!";
    }

    @GetMapping(value = "/api/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/api/users/{id}")
    public User singleUser(@PathVariable("id") int id) throws BusinessException {
        if (userRepo.findById(id).isEmpty()) throw new BusinessException("No value finded on this ID");
        return userRepo.findById(id).get();
    }

    @GetMapping(value = "/api/users/{email}/getMail")
    public User getByEmail(@PathVariable String email) throws BusinessException {
        if (userRepo.findByEmailAddress(email) == null) throw new BusinessException("No value finded on this email");
        return userRepo.findByEmailAddress(email);
    }

    @PostMapping(value = "/api/users/add")
    public void insertUser(@RequestBody User user) throws BusinessException {
        if (user.getName() == null
                || user.getEmail() == null
                || user.getBirth() == null) throw new BusinessException("Required not null values");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @PutMapping(value = "/api/users/{id}/update")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) throws BusinessException {
        if (user.getName() == null || user.getEmail() == null || user.getBirth() == null) throw new BusinessException("Required not null values");
        if (userRepo.findById(id).isEmpty()) throw new BusinessException("User not found");

        User uFinded = userRepo.findById(id).get();
        String pass = passwordEncoder.encode(user.getPassword());
        uFinded.update(user.getName(), user.getEmail(), user.getBirth(), pass);

        userRepo.save(uFinded);
    }

    @DeleteMapping(value = "/api/users/{id}/delete")
    public void deleteUser(@PathVariable("id") int id) throws BusinessException {
        if(userRepo.findById(id).isPresent()) userRepo.deleteById(id);
        else throw new BusinessException("User not found.");
    }
}



