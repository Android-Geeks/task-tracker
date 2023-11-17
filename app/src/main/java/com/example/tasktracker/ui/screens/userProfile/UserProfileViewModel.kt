package com.example.tasktracker.ui.screens.userProfile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserProfileViewModel : ViewModel() {

    private val _userProfUiState = MutableStateFlow(UserProfileUiState())
    val userProfUiState: StateFlow<UserProfileUiState> = _userProfUiState.asStateFlow()

    fun cancelUserDialog(){
        _userProfUiState.update {
            it.copy(
                showUserDialog = false
            )
        }
    }
    fun showUserDialog(){
        _userProfUiState.update {
            it.copy(
                showUserDialog = true
            )
        }
    }
}