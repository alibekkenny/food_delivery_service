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
    public Order createOrder(long userId, Order order) {
        if (userRepo.existsById(userId)) {
            order.setUser(userRepo.findById(userId));
        }
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllByUserId(long userId) {
        return orderRepo.findAllByUserId(userId);
    }

    @Override
    public List<Order> getUsersAllActiveOrders(long userId) {
        return orderRepo.findAllByUserIdAndDeliveryTimeIsNotEmpty(userId);
    }

}
