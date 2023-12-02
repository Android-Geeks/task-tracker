package com.example.tasktracker.ui.dialog.priority

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.R
import com.example.tasktracker.ui.dialog.CustomDialog
import com.example.tasktracker.ui.dialog.DialogViewModel
import com.example.tasktracker.ui.dialog.Dialogs

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PriorityDialog() {

    val priorityList = listOf(
        Priority.ONE,
        Priority.TWO,
        Priority.THREE,
        Priority.FOUR,
        Priority.FIVE,
        Priority.SIX,
        Priority.SEVEN,
        Priority.EIGHT,
        Priority.NINE,
        Priority.TEN
    )
    val dialogUiState by DialogViewModel.dialogUiState.collectAsState()

    CustomDialog(
        title = "Task Priority",
        onConfirmButtonClick = { DialogViewModel.changeCurrentDialog(Dialogs.NONE) },
        onCancelButtonClick = {
            DialogViewModel.apply {
                onPriorityChange(Priority.ONE)
                changeCurrentDialog(Dialogs.NONE)
            }
        }) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(priorityList) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .scale(scaleX = .9f, scaleY = 1f)
                        .background(
                            MaterialTheme.colorScheme.run { if (dialogUiState.priority == item) primary else secondary },
                            RoundedCornerShape(4.dp)
                        )
                        .clickable {
                            DialogViewModel.onPriorityChange(item)
                        }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.flag),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(4f).padding(top = 8.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = (item.ordinal + 1).toString(),
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun Pre_5() {
    PriorityDialog()
}