package com.example.bookclub.screens.bookmarks_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.bookclub.R

@Composable
fun BookProgress(
    progress:Float,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Spacer(
            Modifier
                .height(4.dp)
                .fillMaxWidth(progress/100)
                .background(color = colorResource(R.color.accent_dark), CircleShape)
        )
        Box(
            Modifier
                .height(4.dp)
                .fillMaxWidth()
                .weight(1f)
                .background(color = colorResource(R.color.accent_medium), CircleShape)
        ) {
            Spacer(
                modifier = Modifier
                    .height(4.dp)
                    .width(4.dp)
                    .align(Alignment.CenterEnd)
                    .background(color = colorResource(R.color.accent_dark), CircleShape)
            )
        }
    }
}