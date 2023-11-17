package com.example.tasktracker.ui.screens.userProfile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserProfileViewModel : ViewModel() {

    private val _userProfUiState = MutableStateFlow(UserProfileUiState())
    val userProfUiState: StateFlow<UserProfileUiState> = _userProfUiState.asStateFlow()

    fun onUserNameChange(name: String){
        _userProfUiState.update {
            it.copy(
                userName = name
            )
        }
    }
    fun showUserNameDialog(){
        _userProfUiState.update {
            it.copy(
                showUserNameDialog = true
            )
        }
    }
    fun cancelUserNameDialog(){
        _userProfUiState.update {
            it.copy(
                showUserNameDialog = false
            )
        }
    }

    fun onOldPasswordChange(password: String){
        _userProfUiState.update {
            it.copy(
                oldPassword = password
            )
        }
    }
    fun onNewPasswordChange(password: String){
        _userProfUiState.update {
            it.copy(
                newPassword = password
            )
        }
    }
    fun showUserPasswordDialog(){
        _userProfUiState.update {
            it.copy(
               showUserPasswordDialog = true
            )
        }
    }
    fun cancelUserPasswordDialog(){
        _userProfUiState.update {
            it.copy(
                showUserPasswordDialog = false
            )
        }
    }
    fun cancelImageDiagonal(){
        _userProfUiState.update {
            it.copy(
                showUserImageDialog = false
            )
        }
    }
    fun showImageDiagonal(){
        _userProfUiState.update {
            it.copy(
                showUserImageDialog = true
            )
        }
    }

}