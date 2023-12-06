package com.example.tasktracker.ui.screens.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasktracker.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {TopBar()}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp,start = 24.dp, end = 22.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = stringResource(R.string.settings_title),
                fontWeight = FontWeight(400),
                fontSize = 14.sp,

                )
            SettingsRow(
                icon = painterResource(R.drawable.brush),
                text = stringResource(R.string.change_app_color)
            )
            SettingsRow(
                icon = painterResource(R.drawable.menu),
                text = stringResource(R.string.about_us)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Settings",
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(48.dp)
                    .padding(start = 24.dp)
                    ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)

                )
            }
        },
        modifier = Modifier.fillMaxWidth()

    )
}

@Composable
fun SettingsRow(icon: Painter, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {

        Icon(painter = icon,
            contentDescription = null,
            modifier = Modifier

                .size(45.dp)
                .fillMaxSize()
                .padding(top = 10.dp, bottom = 10.dp, end = 10.dp)
        )

        Text(
            modifier = Modifier
                .weight(8f)
                .size(48.dp)
                .padding(top = 10.dp, bottom = 8.dp),
            text = text,
            lineHeight = 24.08.sp,
            fontWeight = FontWeight(400),
            style = MaterialTheme.typography.bodyLarge,
        )
        IconButton(
            modifier = Modifier
                .size(44.dp)
                .weight(1f),
            onClick = {  }
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun SettingPreview(
) {
    SettingsScreen()
}
