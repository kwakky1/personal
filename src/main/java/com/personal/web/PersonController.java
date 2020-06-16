package com.personal.web;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/login")
public class PersonController {
    @GetMapping("/{userId}")
    public String home(@PathVariable("userId") String userid) {
        System.out.println(userid);
        return userid;
    }
}
