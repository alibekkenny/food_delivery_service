package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final IUserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.createOrSaveUser(user);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        return userService.createOrSaveUser(user);
    }

    @GetMapping("/{phone}")
    public User getUserByPhone(@PathVariable String phone) {
        return userService.getByPhone(phone);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getById(id);
    }
}
