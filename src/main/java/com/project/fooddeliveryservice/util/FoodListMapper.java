package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Food;
import com.project.fooddeliveryservice.dto.FoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = FoodListMapper.class)
public interface FoodListMapper {
    FoodListMapper INSTANCE = Mappers.getMapper(FoodListMapper.class);

    List<Food> foodDtoListToFoodList(List<FoodDto> foodDtoList);

    List<FoodDto> foodListToFoodDtoList(List<Food> foodList);
}
