package com.project.fooddeliveryservice.controller;

import lombok.RequiredArgsConstructor;
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
        return "Hello, the following api's are available: <br> /companies <br>/roles";
    }
}


