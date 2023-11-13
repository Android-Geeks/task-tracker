package com.example.tasktracker.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tasktracker.R
import com.example.tasktracker.TodoViewModel

@Composable
fun LoginScreen(
    todoViewModel: TodoViewModel = viewModel(),
    onRegisterClicked: () -> Unit,
    onBackClick: () -> Unit
) {
    val todoUiState by todoViewModel.todoUiState.collectAsState()

    LoginLayout(
        userName = todoUiState.userName,
        password = todoUiState.password,
        loginSwitch = todoUiState.loginSwitch,
        onUserChange = { todoViewModel.onUsernameChange(it) },
        onPasswordChange = { todoViewModel.onPasswordChange(it) },
        onLoginClicked = { todoViewModel.onLoginClicked() },
        onRegisterClicked = onRegisterClicked,
        onBackClick = onBackClick
    )

}

@Composable
fun LoginLayout(
    userName: String,
    password: String,
    loginSwitch: Boolean,
    onLoginClicked: () -> Unit,
    onPasswordChange: (String) -> Unit,
    onUserChange: (String) -> Unit,
    onRegisterClicked: () -> Unit,
    onBackClick: () -> Unit

) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
            modifier = Modifier
                .padding(top = 12.dp, bottom = 40.dp)
                .clickable(onClick = onBackClick),
            contentDescription = "arrow back"
        )
        Text(
            text = "Login",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(top = 53.dp, bottom = 8.dp),
            text = "Username",
            fontSize = 16.sp
        )
        OutlinedTextField(
            value = userName,
            onValueChange = onUserChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp),
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "Enter your username",
                    fontSize = 16.sp
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
        Text(
            modifier = Modifier.padding(top = 25.dp, bottom = 8.dp),
            text = "Password",
            fontSize = 16.sp
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            placeholder = {
                Row {
                    repeat(12) {
                        Icon(
                            painter = painterResource(id = R.drawable.dot),
                            contentDescription = null,
                            Modifier.padding(4.dp),
                        )
                    }
                }
            },
            visualTransformation = PasswordVisualTransformation(),

            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
        Button(
            onClick = onLoginClicked,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(top = 60.dp, bottom = 30.dp)
                .fillMaxWidth()
                .height(48.dp)
                .alpha(if (loginSwitch) 1f else .5f),
            enabled = loginSwitch,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.primary,
                disabledContentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            DrawLine()
            Text(
                text = "Or",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(horizontal = 4.dp)
            )

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.alpha(.87f),
                text = "Don’t have an account? ",
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier.clickable(onClick = onRegisterClicked),
                text = "Register",
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun DrawLine() {
    // Draw a line using Canvas
    Canvas(
        modifier = Modifier.fillMaxWidth()
    ) {
        val startX = 0f
        val startY = 0f
        val endX = size.width
        val endY = 0f

        // Draw a line from (startX, startY) to (endX, endY)
        drawLine(
            color = Color(0xff979797),
            start = Offset(startX, startY),
            end = Offset((endX), endY),
            strokeWidth = 1.dp.toPx(),
            cap = StrokeCap.Round
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val todoViewModel: TodoViewModel = viewModel()
    LoginScreen(
        todoViewModel, {},{}
    )
}