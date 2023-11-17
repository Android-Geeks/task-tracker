package com.example.tasktracker.ui.screens.userProfile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasktracker.R
import com.example.tasktracker.ui.theme.TaskTrackerTheme
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserProfileScreen(
    userViewModel : UserProfileViewModel = viewModel(),
    userName : String = "Martha Hays"
) {
    val userUiState by userViewModel.userProfUiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
            .padding(top = 13.dp, start = 24.dp, end = 24.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.profile),
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xDEFFFFFF)
            )
            Card(
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 10.dp)
                    .size(85.dp),
                shape = RoundedCornerShape(50.dp)
            ) {

            }
            Text(
                text = userName,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xDEFFFFFF)
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth()
                    .height(58.dp)
            ) {
                TaskNumberCard(
                    cardContent = "10 Task left",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                )

                Spacer(modifier = Modifier.width(20.dp))

                TaskNumberCard(
                    cardContent = "5 Task done",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                )
            }
        }
        Column(
            modifier = Modifier
            .padding(start = 29.dp, end = 19.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Account",
                fontSize = 14.sp,
                color = Color(0xFFAFAFAF),
                textAlign = TextAlign.Start
            )
            AccountSettingItem(
                painterResource(id = R.drawable.user_icon),
                itemContent = "Change account name",
                onItemClicked = {userViewModel.showUserDialog()}
            )
            AccountSettingItem(
                painterResource(id = R.drawable.key),
                itemContent = "Change account password ",
                onItemClicked = {}
            )
            AccountSettingItem(
                painterResource(id = R.drawable.camera),
                itemContent = "Change account Image ",
                onItemClicked = {}
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                text = "Uptodo",
                fontSize = 14.sp,
                color = Color(0xFFAFAFAF),
                textAlign = TextAlign.Start
            )
            Row(
                modifier = Modifier
                    .padding(top = 76.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                IconButton(
                    onClick = { /**/ },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.logout) ,
                        contentDescription = null,
                        tint = Color(0xFFFF4949)
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Log out",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFFF4949),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
    UsernameDialog(userName, userUiState.showUserDialog) { userViewModel.cancelUserDialog() }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun UsernameDialog(
    userName : String,
    showUsernameDialog : Boolean,
    cancelUserDialog : ()-> Unit
) {
    val focusManager = LocalFocusManager.current

    if (showUsernameDialog){
        AlertDialog(
            onDismissRequest = { focusManager.clearFocus()},
            title = {
                Text(
                    text = "Dialog Title",
                    color = Color.White
                )
            },
            containerColor = Color(0xFF363636),
            text = {
                OutlinedTextField(
                    value = userName,
                    onValueChange = {},
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(vertical = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

            },
            confirmButton = {
                Row {
                    Button(
                        onClick = {
                            // Perform any actions needed, then dismiss the dialog

                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .height(48.dp)
                            .width(130.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF8687E7))
                    ) {
                        Text(
                            text = "Edit",
                            color = Color.White,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            },
            dismissButton = {
                Row {
                    Button(
                        onClick = {
                            cancelUserDialog()
                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .height(48.dp)
                            .width(130.dp),
                        colors = ButtonDefaults.buttonColors(Color.Unspecified)
                    ) {
                        Text(
                            text = "Cancel",
                            color = Color(0xFF8875FF),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            },
        )
    }
}

@Preview
@Composable
fun P(){
    UsernameDialog(userName = "", showUsernameDialog = true) {}
}
@Composable
fun AccountSettingItem(
    icon : Painter,
    itemContent : String,
    onItemClicked : () -> Unit

){
    Row(
        modifier = Modifier
            .padding(vertical = 6.dp)
            .fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.White
        )
        Text(
            text = itemContent,
            color = Color.White,
            modifier = Modifier
                .padding(start = 16.dp),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { onItemClicked() }) {
            Icon(
                painter = painterResource(id =R.drawable.baseline_arrow_forward_ios_24 ) ,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun TaskNumberCard(
    cardContent : String,
    modifier: Modifier
){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color(0xFF363636))
    ){
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
            ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = cardContent,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}
@Preview
@Composable
fun UserProfilePreview(){
    TaskTrackerTheme(darkTheme = true)
    { UserProfileScreen() }
}