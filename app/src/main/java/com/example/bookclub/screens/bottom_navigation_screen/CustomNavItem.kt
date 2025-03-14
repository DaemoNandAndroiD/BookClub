package com.example.bookclub.screens.bottom_navigation_screen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import com.example.bookclub.R

@Composable
fun CustomNavItem(
    selectedNavigationIndex:Int,
    imageVector: ImageVector,
    index: Int,
    onClick:()->Unit
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            imageVector,
            contentDescription = null,
            tint = if(selectedNavigationIndex == index) colorResource(R.color.white) else colorResource(R.color.accent_medium)
        )
    }
}