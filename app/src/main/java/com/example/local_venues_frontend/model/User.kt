package com.example.local_venues_frontend.model

data class User(
    val first: String,
    val last: String,
    val username: String,
    val email: String,
    val password: String
)

data class Session(
    val isLoggedIn: Boolean,
    val user: User
)

