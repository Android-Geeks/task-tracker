package com.example.tasktracker.ui.dialog.task

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.R
import com.example.tasktracker.ui.dialog.DialogViewModel
import com.example.tasktracker.ui.dialog.Dialogs
import com.example.tasktracker.ui.dialog.category.CategoryDialog
import com.example.tasktracker.ui.dialog.datetime.DateDialog
import com.example.tasktracker.ui.dialog.datetime.TimeDialog
import com.example.tasktracker.ui.dialog.priority.PriorityDialog

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskBottomSheet() {

    val dialogUiState by DialogViewModel.dialogUiState.collectAsState()

    if (dialogUiState.openTaskBottomSheet) {

        ModalBottomSheet(onDismissRequest = { DialogViewModel.resetDialogUiState() }) {
            Column(
                modifier = Modifier
                    .padding(26.dp)
                    .fillMaxWidth(),
                Arrangement.spacedBy(12.dp)
            ) {
                Text(text = "Add Task", style = MaterialTheme.typography.displaySmall)

                OutlinedTextField(
                    value = dialogUiState.title,
                    onValueChange = { DialogViewModel.onTitleChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.small,
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant),
                    placeholder = {
                        Text(
                            modifier = Modifier,
                            text = "Title",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = null
                    )
                )

                OutlinedTextField(
                    value = dialogUiState.description,
                    onValueChange = { DialogViewModel.onDescriptionChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.small,
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant),
                    placeholder = {
                        Text(
                            modifier = Modifier,
                            text = "Description",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    textStyle = MaterialTheme.typography.bodyMedium,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = null
                    )
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    IconButton(onClick = { DialogViewModel.changeCurrentDialog(Dialogs.DATE) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.timer),
                            contentDescription = "Pick Time",
                            modifier = Modifier.alpha(.87f)
                        )
                    }

                    IconButton(onClick = { DialogViewModel.changeCurrentDialog(Dialogs.CATEGORY) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.tag),
                            contentDescription = "Pick Time",
                            modifier = Modifier.alpha(.87f)
                        )
                    }

                    IconButton(onClick = { DialogViewModel.changeCurrentDialog(Dialogs.FLAG) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.flag),
                            contentDescription = "Pick Time",
                            modifier = Modifier.alpha(.87f)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(onClick = { DialogViewModel.onConfirmClick() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "Pick Time",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }

    when (dialogUiState.currentDialog) {
        Dialogs.DATE -> DateDialog()
        Dialogs.TIME -> TimeDialog()
        Dialogs.FLAG -> PriorityDialog()
        Dialogs.CATEGORY -> CategoryDialog()
        else -> {}
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun Pre() {
    TaskBottomSheet()
}