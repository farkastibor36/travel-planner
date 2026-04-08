package com.example.travel_planner_android

data class UserCreateDto(
    val userName: String,
    val firstName: String,
    val lastName: String,
    val birthDate: String,
    val email: String,
    val password: String
)

data class UserDto(
    val id: Long,
    val userName: String
)
data class LoginRequestDto(
    val userName: String,
    val password: String
)