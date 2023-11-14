package com.example.tasktracker.ui.screens.login


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    fun onUsernameChange(name: String){
        _loginUiState.update {
            it.copy(
                userName = name
            )
        }
    }
    fun onLoginClicked(){
        //TODO
    }

    fun onPasswordChange(password : String){
        _loginUiState.update {
            it.copy(
                password = password,
                loginSwitch = true

            )
        }
    }

}