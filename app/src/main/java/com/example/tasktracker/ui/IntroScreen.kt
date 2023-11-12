@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tasktracker.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasktracker.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IntroScreen() {
    Scaffold () {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.vector),
                contentDescription = null,
                modifier = Modifier.size(95.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "UpTodo",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 40.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewUpTodoScreen() {
    IntroScreen()
}