package com.example.local_venues_frontend.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.local_venues_frontend.BottomNavScreens
import com.example.local_venues_frontend.Home
import com.example.local_venues_frontend.Profile
import com.example.local_venues_frontend.Search
import com.example.local_venues_frontend.ui.home.HomeScreen
import com.example.local_venues_frontend.ui.profile.ProfileScreen
import com.example.local_venues_frontend.ui.search.SearchScreen
import com.example.local_venues_frontend.ui.theme.LocalvenuesfrontendTheme

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