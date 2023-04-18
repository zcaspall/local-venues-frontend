package com.example.local_venues_frontend.network

import com.example.local_venues_frontend.model.User
import retrofit2.Call
import retrofit2.http.POST

interface UserApiService {
    // Registers a user
    @POST("register")
    suspend fun createUser(): Call<User>
}