package com.example.tasktracker.ui.dialog.delete

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.example.tasktracker.ui.dialog.CustomDialog

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DeleteDialog(
    title: String = "Delete Task",
    confirmButtonText: String = "Delete",
    onConfirmButtonClick: () -> Unit = {/*TODO*/ },
    onCancelButtonClick: () -> Unit = { /*TODO*/ }
) {
    CustomDialog(
        title = title,
        confirmButtonText = confirmButtonText,
        onConfirmButtonClick = onConfirmButtonClick,
        onCancelButtonClick = onCancelButtonClick
    ) {
        //TODO
    }
}