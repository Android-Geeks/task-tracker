package com.example.tasktracker.ui.dialog

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.tasktracker.ui.dialog.category.Category
import com.example.tasktracker.ui.dialog.priority.Priority
import java.time.LocalDateTime
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
data class DialogUiState(
    var openTaskBottomSheet: Boolean = false,
    var currentDialog: Dialogs = Dialogs.NONE,
    var title: String = "",
    var description: String = "",
    var date: Long = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
    var time: Long = System.currentTimeMillis() / 1000,
    var tag: Category = Category.None,
    var priority: Priority = Priority.ONE,
)
