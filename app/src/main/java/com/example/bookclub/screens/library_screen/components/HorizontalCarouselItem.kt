package com.example.bookclub.screens.library_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment.BottomLeft
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.library_screen.utils.HorizontalCarouselData
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily

@Composable
fun HorizontalCarouselItem(
    horizontalCarouselData: HorizontalCarouselData,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
    ) {
        Image(
            painterResource(horizontalCarouselData.book),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomStart)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(BottomLeft)
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(R.dimen.small_startend_padding),
                    vertical = dimensionResource(R.dimen.small_startend_padding)
                )
        ) {
            Text(
                text = horizontalCarouselData.description,
                fontSize = 14.sp,
                fontFamily = velaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.white)
            )

            Text(
                text = horizontalCarouselData.title,
                fontSize = 24.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.white)
            )
        }
    }
}

@Preview
@Composable
fun adada(){
    HorizontalCarouselItem(
        HorizontalCarouselData(R.drawable.hunger_games, "Долгожданное продолжение «Голодных игр»", "рассвет жатвы")
    )
}