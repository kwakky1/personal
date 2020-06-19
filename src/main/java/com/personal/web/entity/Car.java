package com.personal.web.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carSeq;
    @Column(length = 200)
    private String img;
    @Column(length = 100)
    private String name;
    @Column(length = 50)
    private String year;
    @Column(length = 50)
    private String km;
    @Column(length = 50)
    private String fuel;
    @Column(length = 50)
    private String price;
}
