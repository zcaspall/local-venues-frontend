package com.example.local_venues_frontend.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val first: String,
    val last: String,
    val username: String,
    val email: String,
    val password: String
)

@Serializable
data class Auth(
    val username: String,
    val password: String
)

@Serializable
data class Cookie(
    val originalMaxAge: Int,
    val expires: String,
    val httpOnly: Boolean,
    val path: String,

)

@Serializable
data class Session(
    val cookie: Cookie,
    val isLoggedIn: Boolean = false,
//    val user: User?,
)

