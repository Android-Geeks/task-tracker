package com.example.tasktracker.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktracker.R
import com.example.tasktracker.ui.theme.TaskTrackerTheme

@Composable
fun TaskItem(
    item: Task,
    onItemClicked: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .background(
                MaterialTheme.colorScheme.surface,
                RoundedCornerShape(4.dp)
            )
            .padding(10.dp)
            .clickable { onItemClicked(item.id) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        PrefixCircle()
        Spacer(modifier = Modifier.size(14.dp))
        Column(
            Modifier.weight(1f)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF86FFFF),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = item.dueDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFAFAFAF),
                )
                Spacer(modifier = Modifier.weight(1f))
                FooterLabel(content = item.category, isStroke = true, icon = R.drawable.sort)
                Spacer(modifier = Modifier.width(12.dp))
                FooterLabel(content = item.priority, isStroke = false, icon = R.drawable.flag)
            }
        }
    }
}

@Composable
fun PrefixCircle() {
    Canvas(modifier = Modifier.size(16.dp), onDraw = {
        drawCircle(color = Color(0xFF86FFFF), style = Stroke(width = 6f))
    })
}

@Composable
fun FooterLabel(
    content: String,
    isStroke: Boolean,
    @DrawableRes icon: Int,
) {
    Box(
        modifier = if (isStroke) {
            Modifier.background(
                color = Color(0xFF809CFF),
                shape = RoundedCornerShape(size = 4.dp)
            )
        } else {
            Modifier.border(1.dp, Color(0xFF809CFF), RoundedCornerShape(size = 4.dp))
        }.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color(0xFF0055A3)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }

    }
}

@Composable
@Preview
fun TaskItemPreview() {
    TaskTrackerTheme(darkTheme = true) {
        TaskItem(item = Task(
            id = "1",
            category = "University",
            description = "do my homework",
            dueDate = "Today At 07:00 AM",
            isCompleted = false,
            priority = "1",
            title = "Do my homework"
        ), onItemClicked = {}
        )
    }
}