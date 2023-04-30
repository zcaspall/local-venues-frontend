package com.example.local_venues_frontend.network

import com.example.local_venues_frontend.model.Auth
import com.example.local_venues_frontend.model.Session
import com.example.local_venues_frontend.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    // Registers a user
    @POST("register")
    fun createUser( @Body user: User): Call<User>

    @POST("login")
    fun loginUser( @Body auth: Auth): Call<Auth>

    @GET("user/session")
    suspend fun getSessionData(): Session
}