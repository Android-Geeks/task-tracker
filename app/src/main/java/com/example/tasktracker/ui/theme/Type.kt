package com.example.tasktracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tasktracker.R


val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.lato_bold, FontWeight.Bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.lato_bold, FontWeight.Bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.lato_bold, FontWeight.Bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.lato_regular, FontWeight.Normal),
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.lato_regular, FontWeight.Normal),
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.lato_regular, FontWeight.Normal),
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
)