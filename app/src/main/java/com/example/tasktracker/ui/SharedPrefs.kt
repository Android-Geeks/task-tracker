package com.example.tasktracker.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object SharedPrefs {
    private lateinit var sharedPreferences: SharedPreferences

    fun setSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences("task_tracker", Context.MODE_PRIVATE)
    }

    fun getOnboardingStatus(): Boolean {
        return sharedPreferences.getBoolean("onboarding_shown", false)
    }

    fun setOnboardingStatus(shown: Boolean) {
        sharedPreferences.edit {
            putBoolean("onboarding_shown", shown)
        }
    }

    fun getLoginStatus(): Boolean {
        return sharedPreferences.getBoolean("login_shown", false)
    }

    fun setLoginStatus(shown: Boolean) {
        sharedPreferences.edit {
            putBoolean("login_shown", shown)
        }
    }
}
