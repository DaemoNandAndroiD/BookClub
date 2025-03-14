package com.example.bookclub.screens.search_screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.ui.theme.alumniSansFontFamily
import java.util.Locale

@Composable
fun CategoryTitle(
    text:String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text.uppercase(Locale.getDefault()),
        fontSize = 24.sp,
        fontFamily = alumniSansFontFamily,
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.accent_dark)
    )
}