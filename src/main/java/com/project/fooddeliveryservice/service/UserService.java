package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public User createOrSaveUser(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public User getByPhone(String phone) {
        return userRepo.findByPhone(phone);
    }

}
