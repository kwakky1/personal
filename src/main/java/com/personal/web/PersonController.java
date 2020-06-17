package com.personal.web;

import com.personal.web.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

@RestController
@RequestMapping("/login")
public class PersonController {
    @Autowired
    CarRepository carRepository;
    @Autowired Crawler crawler;
    @GetMapping("/{userId}")
    public String home(@PathVariable("userId") String userid) {
        System.out.println(userid);
        crawler.oldCar();
        System.out.println(carRepository.findAll().toString());
        return userid;
    }
}
