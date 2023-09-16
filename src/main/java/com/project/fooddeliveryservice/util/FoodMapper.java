package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Food;
import com.project.fooddeliveryservice.dto.FoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = FoodMapper.class)
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food foodDtoToFood(FoodDto foodDto);

    FoodDto foodToFoodDto(Food food);
}
