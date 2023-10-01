package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = OrderFoodListMapper.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "userId", target = "user.id")
    Order orderDtoToOrder(OrderDto orderDto);

    @Mapping(source = "user.id", target = "userId")
    OrderDto orderToOrderDto(Order order);
}
