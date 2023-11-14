package com.example.tasktracker.ui.screens.register


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {

    private val _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()

    fun onUsernameChange(name: String){
        _registerUiState.update {
            it.copy(
                userName = name
            )
        }
    }

    fun onPasswordChange(password : String){
        _registerUiState.update {
            it.copy(
                password = password,

            )
        }
    }
    fun onRegisterClicked(){
        //TODO
    }

    fun onConfirmPassChange(confirmedPassword : String){
        _registerUiState.update {
            it.copy(
                confirmedPassword = confirmedPassword,
                registerButtonSwitch = true
            )
        }

    }
}