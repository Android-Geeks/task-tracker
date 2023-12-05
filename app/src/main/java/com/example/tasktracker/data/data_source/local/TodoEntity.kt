package com.example.tasktracker.data.data_source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
    @PrimaryKey
    val id: String,
    val isCompleted: Boolean
)