package com.example.tasktracker.ui.dialog

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CustomDialog(
    title: String,
    confirmButtonText: String = "Save",
    onConfirmButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    content: @Composable (BoxScope.() -> Unit)
) {
    Dialog(
        onDismissRequest = { DialogViewModel.changeCurrentDialog(Dialogs.NONE) },
        DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(.95f),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                Arrangement.spacedBy(8.dp),
                Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
                Divider(thickness = 1.dp)
                Box(content = content)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TextButton(
                        onClick = onCancelButtonClick,
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = onConfirmButtonClick,
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = confirmButtonText)
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun Pre_4() {
    CustomDialog("Choose Category","Save",{},{},{})
}