package com.example.tasktracker.ui.dialog.datetime

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.tasktracker.ui.dialog.CustomDialog
import com.example.tasktracker.ui.dialog.DialogViewModel
import com.example.tasktracker.ui.dialog.Dialogs
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateDialog(
    title: String = "Select Date",
    confirmButtonText: String = "Choose Time",
    onConfirmButtonClick: () -> Unit = { DialogViewModel.changeCurrentDialog(Dialogs.TIME) },
    onCancelButtonClick: () -> Unit = { DialogViewModel.changeCurrentDialog(Dialogs.NONE) }
) {

    val dialogUiState by DialogViewModel.dialogUiState.collectAsState()
    val datePickerState = remember {
        DatePickerState(
            yearRange = (LocalDateTime.now().year..LocalDateTime.now().year + 5),
            initialSelectedDateMillis = dialogUiState.date,
            initialDisplayMode = DisplayMode.Picker,
            initialDisplayedMonthMillis = null
        )
    }

    CustomDialog(
        title = title,
        confirmButtonText = confirmButtonText,
        onConfirmButtonClick = onConfirmButtonClick.also {
            DialogViewModel.onDateChange(
                datePickerState.selectedDateMillis!!
            )
        },
        onCancelButtonClick = onCancelButtonClick
    ) {
        DatePicker(
            state = datePickerState,
            title = null,
            headline = null,
            showModeToggle = false
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, apiLevel = 27)
@Composable
fun Pre_3() {
    DateDialog()
}