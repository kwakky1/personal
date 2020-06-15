package com.personal.web;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {
    private String userId, password, email, address;
}
