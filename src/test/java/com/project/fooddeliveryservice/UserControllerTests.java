package com.project.fooddeliveryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fooddeliveryservice.controller.CompanyController;
import com.project.fooddeliveryservice.controller.UserController;
import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.dto.CompanyDto;
import com.project.fooddeliveryservice.dto.UserDto;
import com.project.fooddeliveryservice.service.CompanyService;
import com.project.fooddeliveryservice.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private IUserService userService;


    @Test
    public void itShouldCreateUser() throws Exception {
        User user = new User();

        user.setRole(1);
        user.setAddress("Hawaii, Oahu");
        user.setPhone("77777777777");
        user.setFirstName("Max");
        user.setLastName("Holloway");
        user.setPassword("blessed");

        UserDto userDto = new UserDto();

        userDto.setRole(1);
        userDto.setAddress("Hawaii, Oahu");
        userDto.setPhone("77777777777");
        userDto.setFirstName("Max");
        userDto.setLastName("Holloway");
        userDto.setPassword("blessed");

        when(userService.createOrSaveUser(any(User.class))).thenReturn(user);
        mockMvc.perform(post("/users")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.firstName").value(user.getFirstName()));
    }

    @Test
    public void itShouldGetAllUsers() throws Exception {
        var users = List.of(new User(), new User(), new User());
        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        content().string(objectMapper.writeValueAsString(users)));
    }

    @Test
    public void itShouldGetUserById() throws Exception {
        User user = new User();

        user.setRole(1);
        user.setAddress("Hawaii, Oahu");
        user.setPhone("77777777777");
        user.setFirstName("Max");
        user.setLastName("Holloway");
        user.setPassword("blessed");

        when(userService.getById(1)).thenReturn(user);

        mockMvc.perform(get("/users/{id}", 1))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        content().string(objectMapper.writeValueAsString(user)));
    }

    @Test
    public void itShouldUpdateUser() throws Exception {
        User user = new User();

        user.setRole(1);
        user.setAddress("Hawaii, Oahu");
        user.setPhone("77777777777");
        user.setFirstName("Max");
        user.setLastName("Holloway");
        user.setPassword("blessed");

        UserDto userDto = new UserDto();

        userDto.setRole(1);
        userDto.setAddress("Hawaii, Oahu");
        userDto.setPhone("77777777777");
        userDto.setFirstName("Max");
        userDto.setLastName("Holloway");
        userDto.setPassword("blessed");

        when(userService.createOrSaveUser(any(User.class))).thenReturn(user);
        mockMvc.perform(put("/users")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.firstName").value(user.getFirstName()));
    }

    @Test
    public void itShouldGetUserByPhone() throws Exception {
        User user = new User();

        user.setRole(1);
        user.setAddress("Hawaii, Oahu");
        user.setPhone("77777777777");
        user.setFirstName("Max");
        user.setLastName("Holloway");
        user.setPassword("blessed");

        when(userService.getByPhone("77777777777")).thenReturn(user);

        mockMvc.perform(get("/users/phone/{phone}", "77777777777"))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        content().string(objectMapper.writeValueAsString(user)));
    }
}
