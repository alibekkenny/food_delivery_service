package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.project.fooddeliveryservice.data.User;

import java.util.List;

@Mapper(uses = UserListMapper.class)
public interface UserListMapper {
    UserListMapper INSTANCE = Mappers.getMapper(UserListMapper.class);

    List<User> userDtoListToUserList(List<UserDto> userDtoList);

    List<UserDto> userListToUserDtoList(List<User> userList);
}
