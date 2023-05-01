package com.example.local_venues_frontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.local_venues_frontend.ui.LocalVenuesApp
import com.example.local_venues_frontend.ui.home.HomeScreen
import com.example.local_venues_frontend.ui.profile.ProfileScreen
import com.example.local_venues_frontend.ui.search.SearchScreen
import com.example.local_venues_frontend.ui.theme.LocalvenuesfrontendTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalVenuesApp()
        }
    }
}

