package com.example.tasktracker.ui.screens.userProfile

data class UserProfileUiState(
    var userName : String = "Ali",
    var oldPassword : String = "",
    var newPassword : String = "",
    var showUserNameDialog : Boolean = false,
    var showUserPasswordDialog : Boolean = false,
    var showUserImageDialog : Boolean = false,
    )
