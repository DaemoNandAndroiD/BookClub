package com.example.bookclub.screens.bottom_navigation_screen

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.bookclub.R

@Composable
fun BottomNavigationFab(
    onClick:()->Unit
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = colorResource(R.color.red_secondary),
        shape = CircleShape,
        modifier = Modifier.size(80.dp).offset(y = 88.dp)
    ) {
        Icon(
            ImageVector.vectorResource(R.drawable.ic_play),
            contentDescription = null,
            modifier = Modifier.padding(start = 2.dp),
            tint = colorResource(R.color.white)
        )
    }
}