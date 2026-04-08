package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.LoginRequestDto;
import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.mapper.UserMapper;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCRUDServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreateDto userCreateDto) {
        return userRepository.save(userMapper.toCreateEntity(userCreateDto));
    }

    @Override
    public UserDto updateUser(Long id, UserCreateDto userCreateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setUserName(userCreateDto.userName());
        user.setFirstName(userCreateDto.firstName());
        user.setLastName(userCreateDto.lastName());
        user.setBirthDate(userCreateDto.birthDate());
        user.setEmail(userCreateDto.email());
        user.setPassword(userCreateDto.password());

        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public boolean login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByUserName(loginRequestDto.userName());
        if (user == null) {
            throw new RuntimeException("User not found with username: " + loginRequestDto.userName());
        }
        return user != null && user.getPassword().equals(loginRequestDto.password());
    }
}