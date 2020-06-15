package com.personal.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class PersonController {
    @GetMapping("/")
    public String home(){
        return"안녕 그래들";
    }
}
