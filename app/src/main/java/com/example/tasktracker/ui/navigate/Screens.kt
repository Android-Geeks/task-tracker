package com.example.tasktracker.ui.navigate

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tasktracker.R

sealed class Screen(val route: String) {
    object OnBoard : Screen("onboard")
    object Start : Screen("start")
    object Login : Screen("login")
    object Register : Screen("register")
}

sealed class BottomNavScreen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    object Home : BottomNavScreen("home", R.string.home, R.drawable.home)
    object Calender : BottomNavScreen("calender", R.string.calender, R.drawable.calendar)
    object Profile : BottomNavScreen("profile", R.string.profile, R.drawable.profile)
    object Settings : BottomNavScreen("settings", R.string.settings, R.drawable.settings)
}