package com.example.tasktracker.ui.theme.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tasktracker.R
import com.example.tasktracker.TodoViewModel

@Composable
fun LoginScreen(
    todoViewModel: TodoViewModel = viewModel()
){
    val todoUiState by todoViewModel.todoUiState.collectAsState()

    LoginLayout(
        userName = todoUiState.userName,
        password = todoUiState.password,
        loginSwitch = todoUiState.loginSwitch,
        onUserChange = { todoViewModel.onUsernameChange(it) },
        onPasswordChange = {todoViewModel.onPasswordChange(it)},
        onLoginClicked = { todoViewModel.onLoginClicked() },
        onRegisterClicked = {todoViewModel.onRegisterClicked()},
    )

}
@Composable
fun LoginLayout(
    userName : String,
    password : String,
    loginSwitch : Boolean,
    onLoginClicked : () -> Unit,
    onPasswordChange : (String) -> Unit,
    onUserChange : (String) -> Unit,
    onRegisterClicked : () -> Unit,

){
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
            modifier = Modifier.padding(top = 12.dp, bottom = 40.dp),
            tint = Color.White,
            contentDescription = "arrow back"
        )
        Text(
            text = "Login",
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(top = 53.dp, bottom = 8.dp),
            text = "Username",
            fontSize = 16.sp,
            color = Color.White
        )
        OutlinedTextField(
            value = userName,
            onValueChange = onUserChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxHeight(),
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
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                disabledPlaceholderColor = Color(0xff535353),
                focusedTextColor = Color.White
            )
        )
        Text(
            modifier = Modifier.padding(top = 25.dp, bottom = 8.dp),
            text = "Password",
            fontSize = 16.sp,
            color = Color.White
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            placeholder = {
                Row{
                    for (i in 0..12) {
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
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                disabledPlaceholderColor = Color(0xff535353),
                focusedTextColor = Color.White
            )
        )
        Button(
            onClick = onLoginClicked,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(top = 60.dp, bottom = 30.dp)
                .fillMaxWidth()
                .height(48.dp),
            enabled = loginSwitch,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff8687E7),
                contentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0x808687E7),
                disabledContentColor = Color(0x80FFFFFF)

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
        ){
            DrawLine()
            Text(
                text = "Or",
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(color = Color.Black)
                    .padding(horizontal = 4.dp)
            )

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "Don’t have an account? ",
                color = Color(0xff979797),
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier.clickable { onRegisterClicked() },
                text = "Register",
                color = Color.White,
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
fun LoginScreenPreview(){
    val  todoViewModel: TodoViewModel = viewModel()
    LoginScreen(
        todoViewModel
    )
}