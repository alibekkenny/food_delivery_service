package com.project.fooddeliveryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomePageController {
    @GetMapping
    public String home() {
        return "Hello, the following APIs are available: <br>/companies<br>/food_categories<br>/users";
    }

    public static void main(String[] args) {
        SpringApplication.run(HomePageController.class, args);
    }
}


