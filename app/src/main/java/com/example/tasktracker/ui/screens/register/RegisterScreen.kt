package com.example.tasktracker.ui.screens.register

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tasktracker.R
import com.example.tasktracker.ui.screens.login.DrawLine

@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    onLoginClicked: () -> Unit,
    onBackClick: () -> Unit
) {

    val todoUiState by registerViewModel.registerUiState.collectAsState()

    RegisterLayout(
        userName = todoUiState.userName,
        password = todoUiState.password,
        confirmedPassword = todoUiState.confirmedPassword,
        registerButtonSwitch = todoUiState.registerButtonSwitch,
        onRegisterClicked = {registerViewModel.onRegisterClicked() },
        onPasswordChange = { registerViewModel.onPasswordChange(it) },
        onUserChange = { registerViewModel.onUsernameChange(it) },
        onConfirmPassChange = { registerViewModel.onConfirmPassChange(it) },
        onBackClick = onBackClick,
        onLoginClicked = onLoginClicked
    )
}

@Composable
fun RegisterLayout(
    userName: String,
    password: String,
    confirmedPassword: String,
    registerButtonSwitch: Boolean,
    onRegisterClicked: () -> Unit,
    onPasswordChange: (String) -> Unit,
    onUserChange: (String) -> Unit,
    onConfirmPassChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onLoginClicked: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        IconButton(
            onClick =  onBackClick,
            modifier = Modifier
            .padding(top = 12.dp, bottom = 40.dp)
            .size(24.dp)
            ){
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "arrow back"
            )
        }
        Text(
            text = "Register",
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            modifier = Modifier.padding(top = 53.dp, bottom = 8.dp),
            text = "Username",
            style = MaterialTheme.typography.bodySmall
        )
        OutlinedTextField(
            value = userName,
            onValueChange = onUserChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
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
            )
        )
// ----------------------------------------Password----------------------------------------------
        Text(
            modifier = Modifier.padding(top = 25.dp, bottom = 8.dp),
            text = "Password",
            style = MaterialTheme.typography.bodySmall
        )
        PasswordTemplate(
            value = password,
            onValueChange = onPasswordChange,
            focusManager = focusManager
        )
//-------------------------------------Confirm password------------------------------------------
        Text(
            modifier = Modifier.padding(top = 25.dp, bottom = 8.dp),
            text = "Confirm password",
            style = MaterialTheme.typography.bodySmall
        )
        PasswordTemplate(
            value = confirmedPassword,
            onValueChange = onConfirmPassChange,
            focusManager = focusManager
        )
//----------------------------------------Register Button---------------------------------------------
        Button(
            onClick = onRegisterClicked,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(top = 60.dp, bottom = 30.dp)
                .fillMaxWidth()
                .height(53.dp)
                .alpha(if (registerButtonSwitch) 1f else .5f),
            enabled = registerButtonSwitch,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.primary,
                disabledContentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.bodySmall
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            DrawLine()
            Text(
                text = "Or",
                style = MaterialTheme.typography.bodySmall,
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
                text = "Already have an account? ",
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier.clickable(onClick = onLoginClicked),
                text = "Login",
                fontSize = 12.sp
            )
        }
    }
}


@Composable
fun PasswordTemplate(
    value: String,
    onValueChange: (String) -> Unit,
    focusManager: FocusManager
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
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
}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    val registerViewModel: RegisterViewModel = viewModel()
    RegisterScreen(
        registerViewModel, {}, {}
    )
}