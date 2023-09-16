package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = OrderListMapper.class)
public interface OrderListMapper {
    OrderListMapper INSTANCE = Mappers.getMapper(OrderListMapper.class);

    List<Order> orderDtoListToOrderList(List<OrderDto> orderDtoList);

    List<OrderDto> orderListToOrderDtoList(List<Order> orderList);
}
