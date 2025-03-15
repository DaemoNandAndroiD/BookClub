package com.example.bookclub.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookclub.screens.bottom_navigation_screen.Main
import com.example.bookclub.screens.bottom_navigation_screen.MainScreen
import com.example.bookclub.screens.welcome_screen.Welcome
import com.example.bookclub.screens.welcome_screen.WelcomeScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Welcome
    ) {
        composable<Welcome> {
            WelcomeScreen { navController.navigate(Main) }
        }
        composable<Main> {
            MainScreen { navController.navigate(Welcome) }
        }
    }
}