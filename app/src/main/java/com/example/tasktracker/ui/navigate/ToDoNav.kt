package com.example.tasktracker.ui.navigate

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tasktracker.ui.screens.LoginScreen
import com.example.tasktracker.ui.screens.RegisterScreen
import com.example.tasktracker.ui.screens.StartScreen
import com.example.tasktracker.ui.screens.onboarding.OnBoardingScreen

@Composable
fun TaskTrackerApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Screens.OnBoard.name,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        composable(Screens.OnBoard.name) {
            OnBoardingScreen { navController.navigate(Screens.Start.name) }
        }
        composable(Screens.Start.name) {
            StartScreen(
                onBackClick = { navController.navigateUp() },
                onLoginClick = { navController.navigate(Screens.Login.name) },
                onCreateAccountClick = { navController.navigate(Screens.Register.name) })
        }
        composable(Screens.Login.name) {
            LoginScreen(
                onRegisterClicked = {
                    navController.popBackStack()
                    navController.navigate(Screens.Register.name) },
                onBackClick = { navController.navigateUp() } )
        }
        composable(Screens.Register.name) {
            RegisterScreen (
                onLoginClicked = {
                    navController.popBackStack()
                    navController.navigate(Screens.Login.name) },
                onBackClick = { navController.navigateUp() } )
        }
    }
}