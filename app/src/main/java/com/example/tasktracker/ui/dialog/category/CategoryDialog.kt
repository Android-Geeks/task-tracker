package com.example.tasktracker.ui.dialog.category

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.ui.dialog.CustomDialog
import com.example.tasktracker.ui.dialog.DialogViewModel
import com.example.tasktracker.ui.dialog.Dialogs

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CategoryDialog(
    title: String = "Choose Category",
    onConfirmButtonClick: () -> Unit = { DialogViewModel.changeCurrentDialog(Dialogs.NONE) },
    onCancelButtonClick: () -> Unit = {
        DialogViewModel.apply {
            onCategoryChange(Category.None)
            changeCurrentDialog(Dialogs.NONE)
        }
    }
) {
    val dialogUiState by DialogViewModel.dialogUiState.collectAsState()
    val categoryList = listOf(
        Category.Grocery,
        Category.Work,
        Category.Sport,
        Category.Design,
        Category.University,
        Category.Social,
        Category.Music,
        Category.Health,
        Category.Movie,
        Category.Home,
        Category.None
    )
    CustomDialog(
        title = title,
        onConfirmButtonClick = onConfirmButtonClick,
        onCancelButtonClick = onCancelButtonClick
    )
    {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(categoryList) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .alpha(if (dialogUiState.tag == item) 1f else .4f)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                colorResource(id = item.color),
                                RoundedCornerShape(4.dp)
                            )
                            .clickable {
                                DialogViewModel.onCategoryChange(item)
                            }
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = "",
                            modifier = Modifier.padding(16.dp),
                            tint = colorResource(id = item.tint)
                        )
                    }
                    Text(
                        text = stringResource(item.title),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun Pre_2() {
    CategoryDialog()
}