package com.example.tasktracker.ui.screens.home

data class HomeUiState(
    val tasks: List<Task> = listOf(
        Task(
            id = "1",
            category = "math",
            description = "do my homework",
            dueDate = "Today At 07:00 AM",
            isCompleted = false,
            priority = "1",
            title = "do my homework"
        ),
        Task(
            id = "2",
            category = "Math",
            description = "do my homework",
            dueDate = "Today At 02:00 AM",
            isCompleted = true,
            priority = "1",
            title = "do my homework"
        )
    ),
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