package com.example.tasktracker.ui.screens.userProfile

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import com.example.tasktracker.ui.screens.register.PasswordTemplate

@Composable
fun UserProfileScreen(
    userViewModel : UserProfileViewModel = viewModel()
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
//                TODO
            }
            Text(
                text = userUiState.userName,
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
                    cardContent = "10 Task left",     // will replace with specific number
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                )

                Spacer(modifier = Modifier.width(20.dp))

                TaskNumberCard(
                    cardContent = "5 Task done",    // will replace with specific number
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
                onItemClicked = {userViewModel.showUserNameDialog()}
            )
            AccountSettingItem(
                painterResource(id = R.drawable.key),
                itemContent = "Change account password ",
                onItemClicked = {userViewModel.showUserPasswordDialog()}
            )
            AccountSettingItem(
                painterResource(id = R.drawable.camera),
                itemContent = "Change account Image ",
                onItemClicked = {userViewModel.showImageDiagonal()}
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.uptodo),
                fontSize = 14.sp,
                color = Color(0xFFAFAFAF),
                textAlign = TextAlign.Start
            )
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
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
                    modifier = Modifier
                        .clickable { /*TODO*/ }
                        .padding(start = 10.dp),
                    text = "Log out",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFFF4949),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
    UsernameDialog(
        userName = userUiState.userName,
        showUsernameDialog =userUiState.showUserNameDialog,
        cancelUserDialog = { userViewModel.cancelUserNameDialog() },
        onUsernameChange = {userViewModel.onUserNameChange(it)}
    )
    UserPasswordDialog(
        oldPassword = userUiState.oldPassword,
        newPassword = userUiState.newPassword,
        onOldPasswordChange = {userViewModel.onOldPasswordChange(it)} ,
        onNewPasswordChange = {userViewModel.onNewPasswordChange(it)},
        showUserPasswordDialog = userUiState.showUserPasswordDialog,
        cancelUserDialog = {userViewModel.cancelUserPasswordDialog()}
    )
    UserImageDialog(
        showUserImageDialog = userUiState.showUserImageDialog,
        cancelUserDialog = {userViewModel.cancelImageDiagonal()}
    )
}
@Composable
fun UserImageDialog(
    showUserImageDialog : Boolean,
    cancelUserDialog : ()->Unit
){
    if (showUserImageDialog){
        AlertDialog(
            modifier = Modifier.size(324.dp, 192.dp),
            onDismissRequest =  cancelUserDialog ,
            shape = RoundedCornerShape(4.dp),
            title = {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Change account Image",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                    )
            },
            containerColor = Color(0xFF363636),
            text = {
                Column(
                    verticalArrangement = Arrangement.Top
                ){
                    Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                    Text(
                        text = "Import from Google Drive",
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .clickable { /*TODO*/ }
                            .padding(top = 40.dp)
                    )
                }
            },
            confirmButton = {},
            dismissButton = {}
        )
    }
}
@Composable
fun UserPasswordDialog(
    oldPassword : String,
    newPassword : String,
    onOldPasswordChange : (String)-> Unit ,
    onNewPasswordChange : (String)->Unit,
    showUserPasswordDialog : Boolean,
    cancelUserDialog : ()-> Unit
){
    val focusManager = LocalFocusManager.current

    if (showUserPasswordDialog){
        AlertDialog(
            onDismissRequest =  cancelUserDialog ,
            shape = RoundedCornerShape(4.dp),
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Change account password",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            },
            containerColor = Color(0xFF363636),
            text = {
                Column{
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                    Text(
                        text ="Enter old password",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                    PasswordTemplate(
                        value = oldPassword,
                        onValueChange = onOldPasswordChange,
                        focusManager = focusManager,
                    )
                    Text(
                        text ="Enter new password",
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                    PasswordTemplate(
                        value = newPassword,
                        onValueChange = onNewPasswordChange,
                        focusManager = focusManager,
                    )
                }
            },
            confirmButton = {
                Row {
                    Button(
                        onClick = {
//                            check entered password
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
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun UsernameDialog(
    userName : String,
    showUsernameDialog : Boolean,
    cancelUserDialog : ()-> Unit,
    onUsernameChange : (String)-> Unit
) {
    val focusManager = LocalFocusManager.current

    if (showUsernameDialog){
        AlertDialog(
            modifier = Modifier.fillMaxWidth(),
            onDismissRequest =  cancelUserDialog ,
            shape = RoundedCornerShape(4.dp),
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Change account name",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center

                )
            },
            containerColor = Color(0xFF363636),
            text = {
                Column( verticalArrangement = Arrangement.Top){
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                    OutlinedTextField(
                        value = userName,
                        onValueChange = onUsernameChange,
                        shape = MaterialTheme.shapes.medium,
                        singleLine = true,
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
                }
            },
            confirmButton = {
                Row {
                    Button(
                        onClick = {
                            onUsernameChange(userName)
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

