package com.example.local_venues_frontend.data

import com.example.local_venues_frontend.model.User
import com.example.local_venues_frontend.network.UserApiService
import retrofit2.Call

interface UserRepository {
    suspend fun createUser(): Call<User>
}

class NetworkUserRepository (
    private val userApiService: UserApiService
) : UserRepository {
    // Creates a user using userApi
    override suspend fun createUser(): Call<User> = userApiService.createUser()
}