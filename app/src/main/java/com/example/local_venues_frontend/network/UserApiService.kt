package com.example.local_venues_frontend.network

import android.net.http.HttpResponseCache
import com.example.local_venues_frontend.model.Auth
import com.example.local_venues_frontend.model.Session
import com.example.local_venues_frontend.model.User
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    // Registers a user
    @POST("register")
    suspend fun createUser( @Body user: User): Response<Void>

    @POST("login")
    suspend fun loginUser( @Body auth: Auth): Response<Void>

    @GET("user/session")
    suspend fun getSessionData(): Session
}