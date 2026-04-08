package org.example.service;

import org.example.dto.LoginRequestDto;
import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.model.User;

import java.util.List;

public interface UserService {
    User createUser(UserCreateDto userCreateDto);

    UserDto updateUser(Long id, UserCreateDto userCreateDto);

    void deleteUser(Long id);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    boolean login (LoginRequestDto loginRequestDto);
}