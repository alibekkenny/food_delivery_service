package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Order;
import com.project.fooddeliveryservice.dto.OrderDto;
import com.project.fooddeliveryservice.dto.UserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.project.fooddeliveryservice.data.User;
import com.project.fooddeliveryservice.util.OrderMapper;

import java.util.List;

@Mapper(uses = UserMapper.class)
public interface UserListMapper {
    UserListMapper INSTANCE = Mappers.getMapper(UserListMapper.class);

    List<User> userDtoListToUserList(List<UserDto> userDtoList);

//    OrderDto map(Order value);

    List<UserDto> userListToUserDtoList(List<User> userList);
}
