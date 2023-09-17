package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.dto.OrderDto;
import com.project.fooddeliveryservice.dto.UserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);

//    OrderDto map(Order value);

    UserDto userToUserDto(User user);
}
