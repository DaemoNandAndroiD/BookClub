package com.example.bookclub.screens.bookmarks_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.search_screen.components.CategoryTitle
import com.example.bookclub.ui.theme.alumniSansFontFamily
import java.util.Locale

@Composable
fun BookmarksScreen() {



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(horizontal = dimensionResource(R.dimen.small_startend_padding))
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.background))
                    .padding(
                        top = dimensionResource(R.dimen.medium_vertical_padding)
                    ),
                text = stringResource(R.string.bookmarks_title).uppercase(Locale.getDefault()),
                fontSize = 48.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.red_secondary)
            )
        }

        item{
            CategoryTitle(
                text = stringResource(R.string.read_now_category),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.medium_vertical_padding))
            )
        }

        item{
            CategoryTitle(
                text = stringResource(R.string.favorite_books_category),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.medium_vertical_padding))
            )
        }


        item{
            CategoryTitle(
                text = stringResource(R.string.quotes_category),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.medium_vertical_padding))
            )
        }
    }
}


@Preview
@Composable
fun dada() {
    BookmarksScreen()
}