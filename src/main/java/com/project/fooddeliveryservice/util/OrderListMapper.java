package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.project.fooddeliveryservice.util.OrderMapper;

import java.util.List;

@Mapper(uses = OrderMapper.class)
public interface OrderListMapper {
    OrderListMapper INSTANCE = Mappers.getMapper(OrderListMapper.class);

    List<Order> orderDtoListToOrderList(List<OrderDto> orderDtoList);

//    OrderDto map(Order value);

    List<OrderDto> orderListToOrderDtoList(List<Order> orderList);
}
