package com.example.bookclub.screens.search_screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.ui.theme.velaSansFontFamily

@Composable
fun SearchItemText(
    text:String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 14.sp,
        fontFamily = velaSansFontFamily,
        fontWeight = FontWeight.Normal,
        color = colorResource(R.color.accent_dark)
    )
}