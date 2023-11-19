package com.example.tasktracker.ui.dialog

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
object DialogViewModel : ViewModel() {
    private val _dialogUiState = MutableStateFlow(DialogUiState())
    val dialogUiState: StateFlow<DialogUiState>
        get() = _dialogUiState.asStateFlow()

    fun changeCurrentDialog(dialog: Dialogs) {
        _dialogUiState.update { it.copy(currentDialog = dialog) }
    }

    fun openTaskBottomSheet(boolean: Boolean) {
        _dialogUiState.update { it.copy(openTaskBottomSheet = boolean) }
    }

    fun onConfirmClick() {
        //TODO
    }

    fun onTitleChange(text: String) {
        _dialogUiState.update { it.copy(title = text) }
    }

    fun onDescriptionChange(text: String) {
        _dialogUiState.update { it.copy(description = text) }
    }

    fun onTimeChange(time: Long) {
        _dialogUiState.update { it.copy(time = time) }
    }

    fun onDateChange(date: Long) {
        _dialogUiState.update { it.copy(date = date) }
    }

    fun onPriorityChange(priority: Priority) {
        _dialogUiState.update { it.copy(priority = priority) }
    }

    fun onCategoryChange(tag: Category) {
        _dialogUiState.update { it.copy(tag = tag) }
    }

    fun resetDialogUiState() {
        _dialogUiState.update {
            it.copy(
                openTaskBottomSheet = false,
                currentDialog = Dialogs.NONE,
                title = "",
                description = "",
                date = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()
                    .toEpochMilli(),
                time = System.currentTimeMillis() / 1000,
                tag = Category.None,
                priority = Priority.ONE
            )
        }
    }

}