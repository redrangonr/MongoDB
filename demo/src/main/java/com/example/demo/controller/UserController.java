package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UseRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;
    private static final String TOPIC = "tpc-notification-dev";

    @PostMapping("send-notification-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("get-notification-user/{id}")
    public ResponseEntity<User> getUserId(@PathVariable("id") String userId) {
        return userService.findUserId(userId);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return userService.findAll();
    }

    @PutMapping("get-notification-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String userId, @RequestBody User user) {
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("delete-notification-user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String userId) {
        return userService.deleteUser(userId);
    }
}