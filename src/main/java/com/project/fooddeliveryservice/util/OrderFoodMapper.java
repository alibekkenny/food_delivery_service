package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.OrderFood;
import com.project.fooddeliveryservice.dto.OrderFoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = OrderFoodMapper.class)
public interface OrderFoodMapper {
    OrderFoodMapper INSTANCE = Mappers.getMapper(OrderFoodMapper.class);

    OrderFood orderFoodDtoToOrderFood(OrderFoodDto orderFoodDto);

    OrderFoodDto orderFoodToOrderFoodDto(OrderFood orderFood);
}
