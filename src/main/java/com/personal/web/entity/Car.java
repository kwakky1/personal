package com.personal.web.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity(name="car")
@Lazy
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carSeq;
    @Column(length = 200)
    private String img;
    @Column(length = 20)
    private String manufacturer;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String trim;
    @Column(length = 50)
    private String year;
    @Column(length = 50)
    private String km;
    @Column(length = 50)
    private String local;
    @Column(length = 50)
    private String price;
}
