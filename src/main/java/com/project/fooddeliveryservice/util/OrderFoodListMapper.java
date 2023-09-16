package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.OrderFood;
import com.project.fooddeliveryservice.dto.OrderFoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = OrderFoodListMapper.class)
public interface OrderFoodListMapper {
    OrderFoodListMapper INSTANCE = Mappers.getMapper(OrderFoodListMapper.class);

    List<OrderFood> orderFoodDtoListToOrderFoodList(List<OrderFoodDto> orderFoodDtoList);

    List<OrderFoodDto> orderFoodListToOrderFoodDtoList(List<OrderFood> orderFoodList);
}
