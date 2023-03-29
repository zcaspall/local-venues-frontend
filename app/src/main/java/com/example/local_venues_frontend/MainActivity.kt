package com.example.local_venues_frontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

@Composable
fun LocalVenuesApp() {
    LocalvenuesfrontendTheme {
        val navController = rememberNavController()

        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        val currentScreen = BottomNavScreens.find { it.route == currentDestination?.route } ?: Home
        Scaffold(
            bottomBar = {
                BottomNavigation {
                    BottomNavScreens.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(screen.route) },
                            selected = currentScreen == screen,
                            onClick = { navController.navigate(screen.route) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            LocalVenueNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun LocalVenueNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen()
        }
        composable(route = Search.route) {
            SearchScreen()
        }
        composable(route = Profile.route) {
            ProfileScreen()
        }
    }
}