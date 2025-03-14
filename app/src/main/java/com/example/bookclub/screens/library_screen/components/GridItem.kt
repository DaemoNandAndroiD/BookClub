package com.example.bookclub.screens.library_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import java.util.Locale

@Composable
fun GridItem(
    gridItemData: GridItemData,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Image(
            painterResource(gridItemData.book),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .aspectRatio(116f/182f)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = gridItemData.title.uppercase(Locale.getDefault()),
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent_dark),
                fontSize = 14.sp
            )
            Text(
                text = gridItemData.author,
                fontFamily = velaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.accent_dark),
                fontSize = 10.sp
            )
        }
    }
}

@Preview
@Composable
fun fsdfasfas() {
    GridItem(GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"))
}
