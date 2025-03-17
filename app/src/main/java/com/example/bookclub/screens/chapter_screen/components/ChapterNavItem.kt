package com.example.bookclub.screens.chapter_screen.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import com.example.bookclub.R

@Composable
fun ChapterNavItem(
    icon:Int,
    onClick:()->Unit
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = colorResource(R.color.white)
        )
    }
}