package com.example.bookclub.screens.bookmarks_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.bookmarks_screen.components.BookWithProgress
import com.example.bookclub.screens.bookmarks_screen.components.Quote
import com.example.bookclub.screens.bookmarks_screen.utils.ContinueReadingData
import com.example.bookclub.screens.bookmarks_screen.utils.QuoteData
import com.example.bookclub.screens.library_screen.utils.GridItemData
import com.example.bookclub.screens.search_screen.components.CategoryTitle
import com.example.bookclub.screens.search_screen.components.SearchItem
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.georgiaFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import java.util.Locale

@Composable
fun BookmarksScreen(
    onChapterNavigate: (Int) -> Unit,
    onChapterWithQuoteNavigate: (Int, String) -> Unit,
    onBookDetailsNavigate: () -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val continueReadingData = ContinueReadingData(
        R.drawable.image,
        "Код да винчи",
        "Пролог",
        percent = 60f
    )

    val favoriteBooks = listOf(
        GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
        GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
        GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
        GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
        GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    )

    val quotes = listOf(
        QuoteData("Я все еще жив", "Код да винчи", "Дэн Браун", chapterIndex = 1),
        QuoteData("умерщвления плоти", "Код да винчи", "Дэн Браун", chapterIndex = 0),
        QuoteData("Ты не должен бежать", "Код да винчи", "Дэн Браун", chapterIndex = 4)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(horizontal = dimensionResource(R.dimen.small_startend_padding))
            .statusBarsPadding()
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

        item {
            Row(
                modifier = Modifier.padding(top = dimensionResource(R.dimen.medium_vertical_padding))
            ) {
                CategoryTitle(
                    text = stringResource(R.string.read_now_category),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(Modifier.weight(1f))

                IconButton(
                    modifier = Modifier
                        .background(colorResource(R.color.accent_dark), CircleShape),
                    onClick = { onChapterNavigate(8) }
                ) {
                    Icon(
                        ImageVector.vectorResource(R.drawable.ic_play),
                        contentDescription = null,
                        tint = colorResource(R.color.white),
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }
            }
        }

        item {
            BookWithProgress(
                modifier = Modifier
                    .height(screenHeight * 0.15f)
                    .clickable { onBookDetailsNavigate() },
                continueReadingData = continueReadingData,
            )
        }

        item {
            CategoryTitle(
                text = stringResource(R.string.favorite_books_category),
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.medium_vertical_padding),
                    bottom = 8.dp
                )
            )
        }

        items(favoriteBooks.size) {
            SearchItem(
                favoriteBooks[it],
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(screenHeight * 0.15f),
                onClick = onBookDetailsNavigate
            )
        }


        item {
            CategoryTitle(
                text = stringResource(R.string.quotes_category),
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.medium_vertical_padding),
                        bottom = 8.dp
                    )
            )
        }

        items(quotes.size) {
            Quote(
                quotes[it],
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { onChapterWithQuoteNavigate(quotes[it].chapterIndex, quotes[it].quote) })
        }

        item {
            Spacer(modifier = Modifier.height(128.dp))
        }
    }
}