package com.example.tasktracker.ui.screens.home

data class HomeUiState(
    val tasks: List<Task> = emptyList(),
    val user: User = User()
)

data class Task(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val category: String,
    val dueDate: String,
    val priority: String,
)

data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val imageUrl: String = "",
    val tasks: List<Task> = emptyList()
)