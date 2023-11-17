package com.example.tasktracker.ui.navigate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tasktracker.ui.screens.StartScreen
import com.example.tasktracker.ui.screens.home.HomeScreen
import com.example.tasktracker.ui.screens.login.LoginScreen
import com.example.tasktracker.ui.screens.onboarding.OnBoardingScreen
import com.example.tasktracker.ui.screens.register.RegisterScreen

@Composable
fun TaskTrackerApp() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.Calender,
        BottomNavScreen.Profile,
        BottomNavScreen.Settings
    )
    Scaffold(
        bottomBar = {
            val navBackStackEntry = navController.currentBackStackEntryAsState().value
            if (navBackStackEntry?.destination?.route in items.map { it.route })
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    BottomNavigationBar(
                        navBackStackEntry = navBackStackEntry,
                        items = items,
                        onClickItem = {
                            navController.navigate(it) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reSelecting the same item
                                launchSingleTop = true
                                // Restore state when reSelecting a previously selected item
                                restoreState = true
                            }

                        }
                    )
                    AddTaskButton(onClickAddTask = { /*TODO*/ })
                }

        }
    ) { innerPadding ->
        NavHost(
            navController = navController, startDestination = BottomNavScreen.Home.route,
            modifier = Modifier
                .padding(innerPadding)
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            composable(Screen.OnBoard.route) {
                OnBoardingScreen { navController.navigate(Screen.Start.route) }
            }
            composable(Screen.Start.route) {
                StartScreen(
                    onBackClick = { navController.navigateUp() },
                    onLoginClick = { navController.navigate(Screen.Login.route) },
                    onCreateAccountClick = { navController.navigate(Screen.Register.route) })
            }
            composable(Screen.Login.route) {
                LoginScreen(
                    onRegisterClicked = {
                        navController.popBackStack()
                        navController.navigate(Screen.Register.route)
                    },
                    onBackClick = { navController.navigateUp() })
            }
            composable(Screen.Register.route) {
                RegisterScreen(
                    onLoginClicked = {
                        navController.popBackStack()
                        navController.navigate(Screen.Login.route)
                    },
                    onBackClick = { navController.navigateUp() })
            }
            composable(BottomNavScreen.Home.route) {
                HomeScreen()
            }
            composable(BottomNavScreen.Calender.route) {
                Text(text = "Calender")
            }
            composable(BottomNavScreen.Profile.route) {
                Text(text = "Profile")
            }
            composable(BottomNavScreen.Settings.route) {
                Text(text = "Settings")
            }
        }
    }
}