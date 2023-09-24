package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.repository.OrderRepository;
import com.project.fooddeliveryservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;

    @Override
    public Order createOrder(Order order) {
        order.setOrderTime(LocalDateTime.now());
        order.setUser(userRepo.findById(order.getUser().getId()));
        return orderRepo.save(order);
    }

    @Override
    public Order createOrSaveOrder(Order order) {
        order.setOrderTime(LocalDateTime.now());
        return orderRepo.save(order);
    }


    @Override
    public List<Order> getAllByUserId(long userId) {
        return orderRepo.findAllByUserId(userId);
    }

    @Override
    public List<Order> getUsersAllActiveOrders(long userId) {
        return orderRepo.findAllByUserIdAndDeliveryTimeIsNotNull(userId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
