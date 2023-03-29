package com.example.local_venues_frontend

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val icon: ImageVector
    val route: String
}

object Home : Destination {
    override val icon = Icons.Default.Home
    override val route = "home"
}

object Search : Destination {
    override val icon = Icons.Default.Search
    override val route = "search"
}

object Profile : Destination {
    override val icon = Icons.Default.Person
    override val route = "profile"
}

val BottomNavScreens = listOf(Home, Search, Profile)