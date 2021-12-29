package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;
    @Autowired
    private UseRepository useRepository;
    private static final String TOPIC = "tpc-notification-dev";

    public ResponseEntity<User> createUser(User user) {
        try {
            user.setStatus(0);
            user.setReceiverTime(new Date(System.currentTimeMillis()));
//            kafkaTemplate.send(TOPIC,"create",new User(user.getUserId(),user.getNotiMsg(),user.getReceiverTime(),user.getStatus()));
            return new ResponseEntity<>(useRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    public ResponseEntity<?> findAll() {
        List<User> userList = useRepository.findAll();
        if (userList.size() > 0) {

            return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ko tồn tại",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> updateUser(User user, String userId) {
        Optional<User> userOptional = useRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setUserId(userId);
        user.setChangeTime(new Date(System.currentTimeMillis()));
        user.setStatus(1);
        useRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> findUserId(String id) {
        Optional<User> userOptional = useRepository.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userOptional.get(),HttpStatus.OK);
        }
    }
    public ResponseEntity<User> deleteUser(String id){
        try{
            useRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}