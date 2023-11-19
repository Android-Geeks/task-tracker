package com.example.tasktracker.ui.dialog

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tasktracker.R

sealed class Category(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @ColorRes val color: Int,
    @ColorRes val tint: Int
) {
    object Grocery : Category(
        R.string.grocery,
        R.drawable.bread,
        R.color.lime,
        R.color.grocery_tint
    )

    object Work : Category(
        R.string.work,
        R.drawable.briefcase,
        R.color.rose,
        R.color.work_tint

    )

    object Sport : Category(
        R.string.sport,
        R.drawable.sport,
        R.color.teal,
        R.color.sport_tint
    )

    object Design : Category(
        R.string.design,
        R.drawable.design,
        R.color.mint,
        R.color.design_tint
    )

    object University : Category(
        R.string.university,
        R.drawable.mortarboard,
        R.color.blue,
        R.color.university_tint
    )

    object Social : Category(
        R.string.social,
        R.drawable.megaphone,
        R.color.pink,
        R.color.social_tint
    )

    object Music : Category(
        R.string.music,
        R.drawable.music,
        R.color.lavender,
        R.color.music_tint
    )

    object Health : Category(
        R.string.health,
        R.drawable.heartbeat,
        R.color.light_green,
        R.color.health_tint
    )

    object Movie : Category(
        R.string.movie,
        R.drawable.videocamera,
        R.color.aqua,
        R.color.movie_tint
    )

    object Home : Category(
        R.string.home,
        R.drawable.home,
        R.color.orange,
        R.color.home_tint
    )

    object None : Category(
        R.string.none,
        R.drawable.none,
        R.color.mint,
        R.color.design_tint
    )
}