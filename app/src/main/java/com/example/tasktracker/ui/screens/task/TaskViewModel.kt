package com.example.tasktracker.ui.screens.task

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TaskUiState())
    var uiState: StateFlow<TaskUiState> = _uiState.asStateFlow()

    fun updateTime (time:String){
        _uiState.update { change ->
            change.copy(
                taskTime = time,

            )

        }

    }
    fun updateCategory (category:String){
        _uiState.update { change ->
            change.copy(
                taskCategory = category

            )

        }

    }
    fun updatePriority (priority:String){
        _uiState.update { change ->
            change.copy(

                taskPriority = priority
            )

        }

    }
    fun delete(){

    }
    fun edit(){

    }

}