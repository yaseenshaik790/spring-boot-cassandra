package com.sky.cassandra.controller;

import com.sky.cassandra.entity.User;
import com.sky.cassandra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    @DeleteMapping("/users/{id}")
    public String getUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "User deleted successfully with id: "+id;
    }
}
