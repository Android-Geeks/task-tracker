package com.example.tasktracker.ui.dialog.datetime

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.ui.dialog.CustomDialog
import com.example.tasktracker.ui.dialog.DialogViewModel
import com.example.tasktracker.ui.dialog.Dialogs
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneOffset

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeDialog(
    title: String = "Select Time",
    confirmButtonText: String = "Save",
    onConfirmButtonClick: () -> Unit = { DialogViewModel.changeCurrentDialog(Dialogs.NONE) },
    onCancelButtonClick: () -> Unit = { DialogViewModel.changeCurrentDialog(Dialogs.NONE) }
) {

    val dialogUiState by DialogViewModel.dialogUiState.collectAsState()
    val localDateTime = LocalDateTime.ofEpochSecond(
        dialogUiState.time,
        0,
        ZoneId.systemDefault().rules.getOffset(java.time.Instant.now())
    )
    val timePickerState = remember {
        TimePickerState(
            is24Hour = false,
            initialHour = localDateTime.hour,
            initialMinute = localDateTime.minute
        )
    }

    CustomDialog(
        title = title,
        confirmButtonText = confirmButtonText,
        onConfirmButtonClick = onConfirmButtonClick.also {
            DialogViewModel.onTimeChange(
                convertToEpoch(
                    timePickerState.hour,
                    timePickerState.minute
                )
            )
        },
        onCancelButtonClick = onCancelButtonClick
    ) {
        TimeInput(
            state = timePickerState,
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.surfaceVariant,
                    RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertToEpoch(hours: Int, minutes: Int): Long {
    val localTime = LocalTime.of(hours, minutes)
    val localDateTime = LocalDateTime.of(LocalDate.now(), localTime)
    return localDateTime.toEpochSecond(ZoneOffset.UTC)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun TimeDialogPreview() {
    TimeDialog()
}