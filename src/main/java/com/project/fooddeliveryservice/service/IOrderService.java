package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {
    List<Order> getAllByUserId(long userId);

    List<Order> getUsersAllActiveOrders(long userId);

    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order createOrSaveOrder(Order order);
}
