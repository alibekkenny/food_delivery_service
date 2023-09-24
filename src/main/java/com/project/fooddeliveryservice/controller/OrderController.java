package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.dto.OrderDto;
import com.project.fooddeliveryservice.service.IOrderService;
import com.project.fooddeliveryservice.util.OrderListMapper;
import com.project.fooddeliveryservice.util.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    //    @GetMapping("/")
//    public List<OrderDto> getAllOrders() {
//        orderService.ge
//    }
    @PostMapping
    public OrderDto createOrder(OrderDto orderDto) {
        return OrderMapper.INSTANCE.orderToOrderDto(orderService.createOrder(OrderMapper.INSTANCE.orderDtoToOrder(orderDto)));
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return OrderListMapper.INSTANCE.orderListToOrderDtoList(orderService.getAllOrders());
    }

    @PutMapping
    public OrderDto updateOrder(OrderDto orderDto) {
        return OrderMapper.INSTANCE.orderToOrderDto(orderService.createOrSaveOrder(OrderMapper.INSTANCE.orderDtoToOrder(orderDto)));
    }

}
