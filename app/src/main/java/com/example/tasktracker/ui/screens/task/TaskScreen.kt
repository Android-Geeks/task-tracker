package com.example.tasktracker.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.R

@Composable
fun TaskScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        SettingsRow(
            icon = painterResource(R.drawable.ellipse_15),
            text = stringResource(R.string.do_math_homework),
            modifier = Modifier
        )
Row {


    Spacer(modifier = Modifier.width(40.dp))
    Text(
        text = stringResource(R.string.do_chapter_2_to_5_for_next_week),
        fontWeight = FontWeight.Normal,
    )
}
        taskRowWithSmallButton(
            icon = painterResource(R.drawable.timer),
            text = stringResource(R.string.task_time),
            buttonText = stringResource(R.string.today_at)
        )

        taskRowWithSmallButton(
            icon = painterResource(R.drawable.tag),
            text = stringResource(R.string.task_category),
            buttonText = stringResource(R.string.university),
            buttonIcon = painterResource(R.drawable.mortarboard_1)
        )

        taskRowWithSmallButton(
            icon = painterResource(R.drawable.flag),
            text = stringResource(R.string.task_priority),
            buttonText = stringResource(R.string._default)
        )

        SettingsRow(
            icon = painterResource(R.drawable.trash),
            text = stringResource(R.string.delete_task),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(450.dp))
        Button(onClick = {},
            shape=MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(start = 24.dp, top = 12.dp, end = 24.dp, bottom = 12.dp))
            {
                Text(text = stringResource(R.string.edit_task))
            }
        }

    }
@Composable
fun taskRowWithSmallButton(
    icon: Painter,
    text: String,
    buttonText: String? = null,
    buttonIcon: Painter? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SettingsRow(icon = icon, text = text, modifier = Modifier.weight(1f))

        if (buttonText != null || buttonIcon != null) {
            Spacer(modifier = Modifier.width(8.dp))
            SmallButton(btnText = buttonText, btnIcon = buttonIcon, modifier = Modifier.weight(0.7f))
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

        Icon(painter = icon, contentDescription = null)

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.weight(5f),
            text = text,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun SmallButton(
    btnText: String? = null,
    btnIcon: Painter? = null,
    modifier: Modifier
) {
    Button(
        modifier = modifier
            .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            .fillMaxWidth()
        ,
        onClick = { },
        shape = MaterialTheme.shapes.small,
    ) {
        btnIcon?.let { Icon(painter = it, contentDescription = null) }
        btnText?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingPreview() {
    TaskScreen()
}
