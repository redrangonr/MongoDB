package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UseRepository useRepository;

    @PostMapping("send-notification-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setStatus(0);
        user.setReceiverTime(new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(useRepository.save(user), HttpStatus.CREATED);
    }

    @GetMapping("get-notification-user/{id}")
    public ResponseEntity<User> getUserId(@PathVariable("id") String userId) {
        Optional<User> userOptional = useRepository.findById(userId);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<User> userList = useRepository.findAll();
        if (userList.size() > 0) {
            return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("get-notification-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String userId, @RequestBody User user) {
        Optional<User> userOptional = useRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setUserId(userId);
        user.setChangeTime(new Date(System.currentTimeMillis()));
        useRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("delete-notification-user/{id}")
    public  ResponseEntity<User> deleteUser(@PathVariable ("id") String userId){
        try{
            useRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
