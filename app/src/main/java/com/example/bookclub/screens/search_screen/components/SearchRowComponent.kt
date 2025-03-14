package com.example.bookclub.screens.search_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.bookclub.R

@Composable
fun SearchRowComponent(
    content:@Composable() (RowScope.() -> Unit),
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        content = content,
        modifier = modifier.background(color = colorResource(R.color.accent_light), RoundedCornerShape(8.dp))
    )
}