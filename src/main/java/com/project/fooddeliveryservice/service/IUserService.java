package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getById(long id);

    User createOrSaveUser(User user);
//    User updateUser(long id, User user);

    User getByPhone(String phone);
}
