package com.example.tasktracker.ui.navigate

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.tasktracker.R

@Composable
fun BottomNavigationBar(
    navBackStackEntry: NavBackStackEntry?,
    items: List<BottomNavScreen>,
    onClickItem: (String) -> Unit
) {
    BottomNavigation(
        modifier = Modifier
            .height(80.dp),
        backgroundColor = if (isDarkMode(context = LocalContext.current))
            Color(0xff363636)
        else
            Color(0xffF2F2F2)
    ) {
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconId),
                        contentDescription = stringResource(
                            id = screen.resourceId
                        ),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                },
                label = {
                    Text(
                        text = stringResource(screen.resourceId),
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = { onClickItem(screen.route) }
            )
            if (screen.route == "calender") {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun AddTaskButton(
    onClickAddTask: () -> Unit
) {
    IconButton(
        onClick = onClickAddTask,
        modifier = Modifier
            .offset(y = (-40).dp)
            .size(70.dp)
            .clip(CircleShape)
            .background(
                if (isDarkMode(context = LocalContext.current))
                    Color(0xFF3648AC)
                else
                    Color(0xFF8687E7)
            ),
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = stringResource(R.string.add_task),
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

fun isDarkMode(context: Context): Boolean {
    val currentNightMode =
        context.resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
    return currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES
}