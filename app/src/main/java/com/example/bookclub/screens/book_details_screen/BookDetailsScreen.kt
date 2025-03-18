package com.example.bookclub.screens.book_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.book_details_screen.components.ChapterItem
import com.example.bookclub.screens.book_details_screen.components.IconTextButton
import com.example.bookclub.screens.book_details_screen.utils.BookDetailsData
import com.example.bookclub.screens.book_details_screen.utils.bookDetailsData
import com.example.bookclub.screens.bookmarks_screen.components.BookProgress
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import java.util.Locale

@Composable
fun BookDetailsScreen(
    navigateBack: ()->Unit,
    onRead:()->Unit
) {
    var favoriteState by remember { mutableStateOf(false) }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(412f / 380f),
            ) {
                Image(
                    painterResource(bookDetailsData.imageBackground),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color.Transparent,
                            shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp)
                        ),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .align(Alignment.BottomStart)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    colorResource(R.color.background).copy(alpha = 0f),
                                    colorResource(R.color.background)
                                )
                            ),
                        )
                )

                IconButton(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp)
                        .statusBarsPadding()
                        .background(colorResource(R.color.accent_dark), CircleShape),
                    onClick = navigateBack
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = colorResource(R.color.white)
                    )
                }
            }
        }

        item {
            Row(
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.small_startend_padding))
                    .fillMaxWidth()
                    .offset(y = (-24).dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconTextButton(
                    contentColor = R.color.white,
                    containerColor = R.color.accent_dark,
                    textContent = stringResource(R.string.read_button),
                    textIcon = R.drawable.ic_play,
                    modifier = Modifier.fillMaxWidth(0.55f),
                    onClick = onRead
                )

                IconTextButton(
                    contentColor = R.color.accent_dark,
                    containerColor = R.color.accent_light,
                    textContent = if(!favoriteState) stringResource(R.string.bookmark_button_false) else stringResource(R.string.bookmark_button_true),
                    textIcon = if(!favoriteState) R.drawable.ic_bookmarks else R.drawable.ic_done,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        favoriteState = !favoriteState
                    }
                )
            }
        }

        item {
            Text(
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.small_startend_padding)),
                text = bookDetailsData.title.uppercase(Locale.getDefault()),
                fontSize = 48.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent_dark)
            )
        }

        item {
            Text(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(R.dimen.small_startend_padding),
                        top = 8.dp
                    ),
                text = bookDetailsData.author,
                fontSize = 16.sp,
                fontFamily = velaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.accent_dark)
            )
        }

        item {
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.small_startend_padding),
                        vertical = dimensionResource(R.dimen.medium_vertical_padding)
                    ),
                text = bookDetailsData.description,
                fontSize = 16.sp,
                fontFamily = velaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.accent_dark)
            )
        }

        item {
            Text(
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.small_startend_padding)),
                text = stringResource(R.string.progress_section_title).uppercase(Locale.getDefault()),
                fontSize = 24.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent_dark)
            )
        }

        item {
            BookProgress(
                bookDetailsData.percent,
                modifier = Modifier.padding(
                    top = 12.dp,
                    bottom = 20.dp,
                    start = dimensionResource(R.dimen.small_startend_padding),
                    end = dimensionResource(R.dimen.small_startend_padding),
                )
            )
        }

        item {
            Text(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(R.dimen.small_startend_padding),
                    vertical = 8.dp
                ),
                text = stringResource(R.string.chapters_section_title).uppercase(Locale.getDefault()),
                fontSize = 24.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent_dark)
            )
        }

        items(bookDetailsData.chapters.size) {
            ChapterItem(
                chapterData = bookDetailsData.chapters[it],
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.small_startend_padding)),
                onClick = onRead
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}