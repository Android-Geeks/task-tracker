package com.example.tasktracker.ui.dialog

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainDialog(
    title: String = "Select Date",
    confirmButtonText: String = "Choose Time",
    onConfirmButtonClick: () -> Unit = { DialogViewModel.changeCurrentDialog(Dialogs.TIME) },
    onCancelButtonClick: () -> Unit = { DialogViewModel.changeCurrentDialog(Dialogs.NONE) }
) {

    val dialogUiState by DialogViewModel.dialogUiState.collectAsState()

    if (dialogUiState.currentDialog != Dialogs.NONE) {

        when (dialogUiState.currentDialog) {
            Dialogs.DATE -> DateDialog()
            Dialogs.TIME -> TimeDialog()
            Dialogs.FLAG -> PriorityDialog()
            Dialogs.CATEGORY -> CategoryDialog()
            Dialogs.NONE -> {}
        }
    }
}