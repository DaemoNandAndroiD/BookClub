package com.example.bookclub.screens.bookmarks_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.bookmarks_screen.utils.QuoteData
import com.example.bookclub.ui.theme.georgiaFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily

@Composable
fun Quote(
    quoteData: QuoteData,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .background(
                color = colorResource(R.color.accent_light),
                RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    bottom = 8.dp,
                    start = dimensionResource(R.dimen.small_startend_padding),
                    end = dimensionResource(R.dimen.small_startend_padding)
                ),
            text = quoteData.quote,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = georgiaFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.black)
        )
        Text(
            modifier = Modifier
                .padding(
                    bottom = 12.dp,
                    start = dimensionResource(R.dimen.small_startend_padding),
                    end = dimensionResource(R.dimen.small_startend_padding)
                ),
            text = quoteData.bookTitle + " • " + quoteData.author,
            fontSize = 10.sp,
            fontFamily = velaSansFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.accent_dark)
        )
    }
}