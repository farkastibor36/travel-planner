package org.example.mapper;

import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    User toCreateEntity(UserCreateDto userCreateDto);
}