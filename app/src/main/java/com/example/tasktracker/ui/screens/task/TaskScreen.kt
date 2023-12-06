package com.example.tasktracker.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tasktracker.R
import com.example.tasktracker.R.drawable
import com.example.tasktracker.R.string

@Composable
fun TaskScreen(taskViewModel: TaskViewModel= viewModel()) {
    val taskUiState by taskViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(34.dp),
    ) {
        Row {
            Icon(
                painter = painterResource(drawable.ellipse_15),
                contentDescription = null, tint = Color.White,
                modifier = Modifier.padding(end = 10.dp, top = 8.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 20.sp))
                    {
                        append("Do Math Homework\n\n")
                    }
                    withStyle(style = SpanStyle(fontSize = 16.sp)) {
                        append("Do chapter 2 to 5 for next week")
                    }
                },
                color = Color.White,
                modifier = Modifier.weight(2f)
            )
            Icon(
                painter = painterResource(R.drawable.edit_2),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.weight(0.2f)
            )
        }
        Row {
            SettingsRow(
                icon = painterResource(drawable.timer),
                text = stringResource(string.task_time),
                modifier = Modifier.weight(1f)
            )
            Box(
                Modifier
                    .weight(0.5f)
                    .width(108.dp)
                    .height(40.dp)
                    .background(
                        color = Color(0x36FFFFFF),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
            {
                Text(
                    text = taskUiState.taskTime,
                    fontSize = 12.sp,
                    color=Color(0xDEFFFFFF),
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
        Row {


            SettingsRow(
                icon = painterResource(drawable.tag),
                text = stringResource(string.task_category),
                modifier = Modifier.weight(1f)
            )
            Box(
                Modifier
                    .weight(0.6f)
                    .width(118.dp)
                    .height(40.dp)
                    .background(
                        color = Color(0x36FFFFFF),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
            {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.mortarboard_1),
                        contentDescription = null,
                        tint = Color.Blue
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = taskUiState.taskCategory,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        color=Color(0xDEFFFFFF),
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        modifier = Modifier.padding(top = 4.dp)
                    )

                }
            }
        }
        Row {


            SettingsRow(
                icon = painterResource(drawable.flag),
                text = stringResource(string.task_priority),
                modifier = Modifier.weight(1f)
            )
            Box(
                Modifier
                    .weight(0.3f)
                    .width(70.dp)
                    .height(40.dp)
                    .background(
                        color = Color(0x36FFFFFF),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(start = 20.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            )
            {
                Text(
                    text = taskUiState.taskPriority,
                    fontSize = 12.sp,
                    color=Color(0xDEFFFFFF),
                    lineHeight = 40.sp,
                    fontWeight = FontWeight(400),

                    modifier = Modifier.padding(top = 4.dp)

                )
            }
        }

        DeleteRow(
            text = stringResource(string.delete_task),
            modifier = Modifier.fillMaxWidth(),
            onClick = {}

        )
        Spacer(modifier = Modifier.height(280.dp))
        Button(
            onClick = {},
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .height(84.dp)
                .padding(top = 12.dp, bottom = 12.dp)
        )
        {
            Text(
                text = stringResource(string.edit_task),
                fontSize = 16.sp
            )
        }
    }
}


@Composable
fun SettingsRow(
    icon: Painter,
    text: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ) {

        Icon(painter = icon, contentDescription = null, tint = Color.White)

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.weight(5f),
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun DeleteRow(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable { onClick }
    ) {

        Icon(
            painter = painterResource(R.drawable.trash),
            contentDescription = null, tint = Color.Red
        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.weight(5f),
            text = text,
            color = Color.Red,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}



@Preview()
@Composable
fun SettingPreview(
) {
    TaskScreen(

    )
}
