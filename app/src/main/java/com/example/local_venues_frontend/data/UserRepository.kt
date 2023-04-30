package com.example.local_venues_frontend.data

import com.example.local_venues_frontend.model.Auth
import com.example.local_venues_frontend.model.Session
import com.example.local_venues_frontend.model.User
import com.example.local_venues_frontend.network.UserApiService
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body

interface UserRepository {
    suspend fun createUser(@Body user: User): Call<User>

    suspend fun loginUser(@Body auth: Auth): Call<Auth>

    suspend fun getSessionData(): Session
}

class NetworkUserRepository (
    private val userApiService: UserApiService,
) : UserRepository {
    // Creates a user using userApi
    override suspend fun createUser(@Body user: User): Call<User> = userApiService.createUser(user)

    override suspend fun loginUser(@Body auth: Auth): Call<Auth> = userApiService.loginUser(auth)

    override suspend fun getSessionData(): Session = userApiService.getSessionData()
}