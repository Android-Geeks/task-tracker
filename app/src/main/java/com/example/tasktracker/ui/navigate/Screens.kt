package com.example.tasktracker.ui.navigate

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tasktracker.R

sealed class Screen(val route: String) {
    data object OnBoard : Screen("onboard")
    data object Start : Screen("start")
    data object Login : Screen("login")
    data object Register : Screen("register")
}

sealed class BottomNavScreen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    data object Home : BottomNavScreen("home", R.string.home, R.drawable.home)
    data object Calender : BottomNavScreen("calender", R.string.calender, R.drawable.calendar)
    data object Profile : BottomNavScreen("profile", R.string.profile, R.drawable.profile)
    data object Settings : BottomNavScreen("settings", R.string.settings, R.drawable.settings)
}