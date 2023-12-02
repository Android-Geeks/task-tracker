package com.example.tasktracker.ui.screens.login


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    fun onUsernameChange(name: String) {
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