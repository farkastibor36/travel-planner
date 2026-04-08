package com.example.travel_planner_android

import retrofit2.Response
import retrofit2.http.*
interface ApiService {
    @POST("api/login")
    suspend fun login(@Body request: LoginRequestDto): Response<Void>
    @POST("api/users")
    suspend fun createUser(@Body user: UserCreateDto): Response<UserDto>

    @GET("api/users")
    suspend fun getAllUsers(): Response<List<UserDto>>

    @GET("api/users/{id}")
    suspend fun getUserById(@Path("id") id: Long): Response<UserDto>

    @PUT("api/users/{id}")
    suspend fun updateUser(@Path("id") id: Long, @Body user: UserCreateDto): Response<UserDto>

    @DELETE("api/users/{id}")
    suspend fun deleteUser(@Path("id") id: Long): Response<Void>
}