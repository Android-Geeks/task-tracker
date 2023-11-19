package com.example.tasktracker.ui.dialog

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
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
        confirmButtonText = confirmButtonText.also { DialogViewModel.onDateChange(datePickerState.selectedDateMillis!!) },
        onConfirmButtonClick = onConfirmButtonClick,
        onCancelButtonClick = onCancelButtonClick
    ) {
        Box { DatePicker(state = datePickerState, title = null) }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun Pre_3() {
    DateDialog()
}