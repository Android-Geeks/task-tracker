package com.example.tasktracker.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tasktracker.R
import com.example.tasktracker.ui.theme.TaskTrackerTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
) {
    val uiState = viewModel.uiState.value
    Scaffold(
        topBar = {
            HomeTopAppBar(
                imageUrl = uiState.user.imageUrl,
                onClickProfile = viewModel::onProfileClicked,
                onClickSort = viewModel::onClickSort
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            if (uiState.tasks.isEmpty()) {
                EmptyTasks()
            } else {
                TasksList(
                    tasks = uiState.tasks,
                    onTaskClicked = viewModel::onTaskClicked
                )
            }
        }
    }
}


@Composable
fun TasksList(tasks: List<Task>, onTaskClicked: (String) -> Unit) {

}


@Composable
fun EmptyTasks() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty_task),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.what_do_you_want_to_do_today),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.tap_to_add_your_tasks),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun HomeScreenDarkPreview() {
    TaskTrackerTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview
@Composable
fun HomeScreenLightPreview() {
    TaskTrackerTheme(darkTheme = false) {
        HomeScreen()
    }
}