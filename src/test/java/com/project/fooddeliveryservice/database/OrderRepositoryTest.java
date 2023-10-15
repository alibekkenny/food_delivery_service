package com.project.fooddeliveryservice.database;

import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.repository.OrderRepository;
import com.project.fooddeliveryservice.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    private User createUser() {
        User user = new User();
        user.setFirstName("Jon");
        user.setLastName("Jones");
        user.setAddress("Hawaii, Oahu");
        user.setPhone("+77777777777");
        user.setPassword("bones");
        user.setRole(1);
        return user;
    }

    private Order createOrder(User user) {
        Order order = new Order();
        order.setUser(user);
        order.setOrderTime(LocalDateTime.of(2023, 10, 15, 14, 30));
        order.setTotalCost(13.5);
        order.setAddress("Hawaii, Oahu");
        return order;
    }

    @Test
    @DisplayName("Create Order")
    public void itShouldCreateOrder() {
        User user = createUser();
        userRepository.save(user);
        Order order = createOrder(user);
        orderRepository.save(order);
        boolean condition = orderRepository.existsById(order.getId());
        assertTrue(condition);
    }

    //      List<Order> findAllByUserId(@Param("userId") long userId);
    @Test
    @DisplayName("Find Orders by User id")
    public void itShouldFindOrderByUserId() {
        User user = createUser();
        userRepository.save(user);
        Order order = createOrder(user);
        orderRepository.save(order);
        List<Order> foundOrders = orderRepository.findAllByUserId(user.getId());
        boolean condition = foundOrders.get(foundOrders.size() - 1).toString().equals(order.toString());
        assertTrue(condition);
    }

    //
//    List<Order> findAllByUserIdAndDeliveryTimeIsNotNull(@Param("userId") long userId);
    @Test
    @DisplayName("Find Orders by User id, which are not delivered")
    public void itShouldFindOrdersByUserIdAndDeliveryTimeIsNotNull() {
        User user = createUser();
        userRepository.save(user);
        Order order = createOrder(user);
        order.setDeliveryTime(LocalDateTime.of(2023, 10, 15, 14, 52));
        orderRepository.save(order);
        List<Order> foundOrders = orderRepository.findAllByUserIdAndDeliveryTimeIsNotNull(user.getId());
        boolean condition = foundOrders.get(foundOrders.size() - 1).toString().equals(order.toString());
        assertTrue(condition);
    }
}
