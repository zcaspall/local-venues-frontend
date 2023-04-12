package com.example.local_venues_frontend.ui.data

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class User (
    val first: String,
    val last: String,
    val username: String,
    val email: String,
    val password: String
)

public interface UserApi {
    @POST("register")
    fun createUser( @Body user: User): Call<User>

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

