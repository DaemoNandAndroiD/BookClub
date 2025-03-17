package com.example.bookclub.screens.bookmarks_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.bookmarks_screen.utils.ContinueReadingData
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import java.util.Locale

@Composable
fun BookWithProgress(
    modifier: Modifier = Modifier,
    continueReadingData: ContinueReadingData

) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painterResource(continueReadingData.bookImage),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(80f / 126f)
        )

        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = continueReadingData.title.uppercase(Locale.getDefault()),
                    fontSize = 24.sp,
                    fontFamily = alumniSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.accent_dark)
                )
                Text(
                    text = continueReadingData.stage,
                    fontSize = 14.sp,
                    fontFamily = velaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.accent_dark)
                )
            }

            BookProgress(continueReadingData.percent, modifier = Modifier.padding(top = 16.dp))
        }
    }
}

