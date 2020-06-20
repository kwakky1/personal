package com.personal.web.controller;

import com.personal.web.entity.User;
import com.personal.web.repository.CarRepository;
import com.personal.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired CarRepository carRepository;
    @Autowired UserRepository userRepository;

    @PostMapping("/")
    public boolean login(@RequestBody User user) {
        boolean result = false;
        User u = userRepository.findByUserId(user.getUserId());
        if(u != null){
            if(user.getUserId().equals(u.getUserId()) ||
               user.getPassword().equals(u.getPassword())){
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
    @PostMapping("/join")
    public boolean signup(@RequestBody User user){
        userRepository.save(user);
        return true;
    }
    @GetMapping("/check/{userId}")
    public Boolean idCheck(@PathVariable("userId") String userId) {
        System.out.println(userId);
        return userRepository.findByUserId(userId)!=null ? true : false;
    }
}
