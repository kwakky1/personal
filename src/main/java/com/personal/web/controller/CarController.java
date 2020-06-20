package com.personal.web.controller;

import com.personal.web.Crawler;
import com.personal.web.entity.Car;
import com.personal.web.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @Autowired
    Crawler crawler;
    @GetMapping("/list")
    public List<Car> findCar(){
        if(carRepository.count()==0){crawler.oldCar();}
        return carRepository.findAll();
    }
}
