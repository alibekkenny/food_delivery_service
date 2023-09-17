package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.dto.UserDto;
import com.project.fooddeliveryservice.service.IUserService;
import com.project.fooddeliveryservice.util.UserListMapper;
import com.project.fooddeliveryservice.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        return UserListMapper.INSTANCE.userListToUserDtoList(userService.getAllUsers());
    }

    @PostMapping("/")
    public UserDto createUser(@RequestBody UserDto user) {
        return UserMapper.INSTANCE.userToUserDto(
                userService.createOrSaveUser(UserMapper.INSTANCE.userDtoToUser(user))
        );
    }

    @PutMapping("/")
    public UserDto updateUser(@RequestBody UserDto user) {
        return UserMapper.INSTANCE.userToUserDto(
                userService.createOrSaveUser(UserMapper.INSTANCE.userDtoToUser(user))
        );
    }

    @GetMapping("/phone/{phone}")
    public UserDto getUserByPhone(@PathVariable String phone) {
        return UserMapper.INSTANCE.userToUserDto(userService.getByPhone(phone));
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return UserMapper.INSTANCE.userToUserDto(userService.getById(id));
    }
}
