package com.example.local_venues_frontend.ui.data

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

data class User (
    val first: String,
    val last: String,
    val username: String,
    val email: String,
    val password: String
)

interface UserApi {
    @POST("register")
    fun createUser( @Body user: User) : Call<User>
}

