package com.example.tasktracker


import androidx.lifecycle.ViewModel
import com.example.tasktracker.data.TodoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel : ViewModel() {

    private val _todoUiState = MutableStateFlow(TodoUiState())
    val todoUiState: StateFlow<TodoUiState> = _todoUiState.asStateFlow()

    fun onUsernameChange(name: String){
        _todoUiState.update {
            it.copy(
                userName = name
            )
        }
    }
    fun onLoginClicked(){
        //TODO
    }

    fun onPasswordChange(password : String){
        _todoUiState.update {
            it.copy(
                password = password,
                loginSwitch = true

            )
        }
    }
    fun onRegisterClicked(){
         //TODO
    }

    fun onConfirmPassChange(confirmedPassword : String){
        _todoUiState.update {
            it.copy(
                confirmedPassword = confirmedPassword,
                registerButtonSwitch = true
                )
        }

    }
}