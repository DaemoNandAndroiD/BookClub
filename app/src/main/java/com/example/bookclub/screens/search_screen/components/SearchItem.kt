package com.example.bookclub.screens.search_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.library_screen.utils.GridItemData
import com.example.bookclub.screens.search_screen.SearchScreen
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import java.util.Locale

@Composable
fun SearchItem(
    gridItemData: GridItemData,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painterResource(gridItemData.book),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight().aspectRatio(80f/126f),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = gridItemData.title.uppercase(Locale.getDefault()),
                fontSize = 24.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent_dark)
            )
            Text(
                text = gridItemData.author,
                fontSize = 14.sp,
                fontFamily = velaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.accent_dark)
            )
        }
    }
}