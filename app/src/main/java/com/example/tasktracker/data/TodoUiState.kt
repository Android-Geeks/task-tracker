package com.example.tasktracker.data


data class TodoUiState(
    var userName : String = "",
    var password : String = "",
    var confirmedPassword : String = "",
    var loginSwitch : Boolean = false,
    var registerButtonSwitch : Boolean = false
)
