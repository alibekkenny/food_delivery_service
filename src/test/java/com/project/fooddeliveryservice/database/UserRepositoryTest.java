package com.project.fooddeliveryservice.database;

import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private User createUser() {
        User user = new User();
        user.setFirstName("Jon");
        user.setLastName("Jones");
        user.setAddress("Hawaii, Oahu");
        user.setPhone("+159357");
        user.setPassword("bones");
        user.setRole(1);
        return user;
    }

    @Test
    @DisplayName("Create user")
    public void itShouldCreateUser() {
        User user = createUser();
        userRepository.save(user);
        boolean condition = userRepository.existsById(user.getId());
        assertTrue(condition);
    }

    //     User findById(@Param("id") long id);
    @Test
    @DisplayName("Find User by id")
    public void itShouldFindUserById() {
        User user = createUser();
        userRepository.save(user);
        boolean condition = userRepository.findById(user.getId()).toString().equals(user.toString());
        assertTrue(condition);
    }

    //     User findByPhone(@Param("phone") String phone);
    @Test
    @DisplayName("Find User by phone")
    public void itShouldFindUserByPhone() {
        User user = createUser();
        userRepository.save(user);
        boolean condition = userRepository.findByPhone(user.getPhone()).toString().equals(user.toString());
        assertTrue(condition);
    }
}
