package com.example.tasktracker.screen.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tasktracker.R

sealed class OnBoardingPage(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
) {
    object First : OnBoardingPage(
        title = R.string.manage_your_tasks,
        description = R.string.you_can_easily_manage_all_of_your_daily_tasks_in_uptodo_for_free,
        image = R.drawable.onboarding_first
    )

    object Second : OnBoardingPage(
        title = R.string.create_daily_routine,
        description = R.string.in_uptodo_you_can_create_your_personalized_routine_to_stay_productive,
        image = R.drawable.onboarding_second
    )

    object Third : OnBoardingPage(
        title = R.string.organize_your_tasks,
        description = R.string.you_can_organize_your_daily_tasks_by_adding_your_tasks_into_separate_categories,
        image = R.drawable.onboarding_third
    )
}