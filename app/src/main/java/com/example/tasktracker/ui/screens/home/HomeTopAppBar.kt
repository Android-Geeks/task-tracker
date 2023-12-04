package com.example.tasktracker.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.tasktracker.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    imageUrl: String,
    onClickProfile: () -> Unit,
    onClickSort: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Home",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        actions = {
            IconButton(onClick = onClickProfile) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Profile",
                    placeholder = painterResource(id = R.drawable.user_profile),
                    error = painterResource(id = R.drawable.user_profile),
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onClickSort) {
                Icon(
                    painter = painterResource(id = R.drawable.sort),
                    contentDescription = "Sort",
                )
            }
        }
    )
}