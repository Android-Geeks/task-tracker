package com.example.tasktracker.ui.screens.register

data class RegisterUiState(
    var userName : String = "",
    var password : String = "",
    var confirmedPassword : String = "",
    var registerButtonSwitch : Boolean = false
)
