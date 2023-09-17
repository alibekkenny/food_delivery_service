package com.project.fooddeliveryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fooddeliveryservice.controller.CompanyController;
import com.project.fooddeliveryservice.controller.OrderController;
import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.dto.CompanyDto;
import com.project.fooddeliveryservice.dto.OrderDto;
import com.project.fooddeliveryservice.service.CompanyService;
import com.project.fooddeliveryservice.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = OrderController.class)
public class OrderControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private OrderService orderService;


    @Test
    public void itShouldCreateOrder() throws Exception {
        Order order = new Order();

        order.setOrderTime(LocalDateTime.now());
        order.setAddress("Hawaii, Oahu");
        order.setTotalCost(555.77);

        OrderDto orderDto = new OrderDto();

        order.setOrderTime(order.getOrderTime());
        order.setAddress("Hawaii, Oahu");
        order.setTotalCost(555.77);

        when(orderService.createOrder(any(Order.class))).thenReturn(order);
        mockMvc.perform(post("/orders")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.address").value(order.getAddress()));
    }

    @Test
    public void itShouldGetAllOrders() throws Exception {
        var orders = List.of(new Order(), new Order(), new Order());
        when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(get("/orders"))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        content().string(objectMapper.writeValueAsString(orders)));
    }

    @Test
    public void itShouldUpdateOrder() throws Exception {
        Order order = new Order();

        order.setOrderTime(LocalDateTime.now());
        order.setAddress("Hawaii, Oahu");
        order.setTotalCost(555.77);

        OrderDto orderDto = new OrderDto();

        order.setOrderTime(order.getOrderTime());
        order.setAddress("Hawaii, Oahu");
        order.setTotalCost(555.77);

        when(orderService.createOrSaveOrder(any(Order.class))).thenReturn(order);
        mockMvc.perform(put("/orders")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.address").value(order.getAddress()));
    }

}
