package com.personal.web.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
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
    @Builder
    public Car(String img,String name,String year,String km,String fuel,String price) {
        this.img = img;
        this.name = name;
        this.year = year;
        this.km = km;
        this.fuel = fuel;
        this.price = price;
    }
}
