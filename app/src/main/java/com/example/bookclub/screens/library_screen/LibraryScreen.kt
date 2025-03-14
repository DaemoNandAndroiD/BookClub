package com.example.bookclub.screens.library_screen

import android.view.LayoutInflater
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.gestures.snapping.snapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookclub.R
import com.example.bookclub.screens.library_screen.components.GridItem
import com.example.bookclub.screens.library_screen.components.HorizontalCarouselItem
import com.example.bookclub.screens.library_screen.utils.CarouselAdapter
import com.example.bookclub.screens.library_screen.utils.GridItemData
import com.example.bookclub.screens.library_screen.utils.HorizontalCarouselData
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun LibraryScreen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val items = listOf<HorizontalCarouselData>(
        HorizontalCarouselData(
            R.drawable.hunger_games,
            "Долгожданное продолжение «Голодных игр»",
            "РАССВЕТ ЖАТВЫ"
        ),
        HorizontalCarouselData(
            R.drawable.hunger_games,
            "Долгожданное продолжение «Голодных игр»",
            "РАССВЕТ ЖАТВЫ"
        ),
        HorizontalCarouselData(
            R.drawable.hunger_games,
            "Долгожданное продолжение «Голодных игр»",
            "РАССВЕТ ЖАТВЫ"
        ),
        HorizontalCarouselData(
            R.drawable.hunger_games,
            "Долгожданное продолжение «Голодных игр»",
            "РАССВЕТ ЖАТВЫ"
        ),
        HorizontalCarouselData(
            R.drawable.hunger_games,
            "Долгожданное продолжение «Голодных игр»",
            "РАССВЕТ ЖАТВЫ"
        ),
        HorizontalCarouselData(
            R.drawable.hunger_games,
            "Долгожданное продолжение «Голодных игр»",
            "РАССВЕТ ЖАТВЫ"
        ),
    )

    val itemsGrid = listOf(
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
        GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        item{
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.background))
                    .padding(
                        start = dimensionResource(R.dimen.small_startend_padding),
                        top = dimensionResource(R.dimen.medium_vertical_padding)
                    ),
                text = stringResource(R.string.library_title),
                fontSize = 48.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.red_secondary)
            )
        }

        item{
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(R.dimen.small_startend_padding),
                        end = dimensionResource(R.dimen.small_startend_padding),
                        top = dimensionResource(R.dimen.medium_vertical_padding)
                    )
            ) {
                Text(
                    text = stringResource(R.string.new_small_title),
                    fontSize = 24.sp,
                    fontFamily = alumniSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.accent_dark)
                )

                AndroidView(
                    factory = {
                        val view =
                            LayoutInflater.from(it).inflate(R.layout.hero_carousel, null, false)
                        val recyclerView = view.findViewById<RecyclerView>(R.id.carousel)

                        val manager = CarouselLayoutManager(HeroCarouselStrategy())
                        manager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
                        recyclerView.layoutManager = manager
                        val snapHelper = CarouselSnapHelper()
                        snapHelper.attachToRecyclerView(recyclerView)
                        recyclerView.adapter = CarouselAdapter(items)

                        recyclerView
                    }
                )

                Text(
                    text = stringResource(R.string.popular_small_title),
                    fontSize = 24.sp,
                    fontFamily = alumniSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.accent_dark)
                )
            }
        }

        items((itemsGrid.size/3).toInt()){
            FlowRow(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                GridItem(itemsGrid[it*3], modifier = Modifier.width((screenWidth-64.dp)/3))
                GridItem(itemsGrid[it*3+1], modifier = Modifier.width((screenWidth-64.dp)/3))
                GridItem(itemsGrid[it*3+2], modifier = Modifier.width((screenWidth-64.dp)/3))
            }
        }
    }
}

@Preview
@Composable
fun adadad() {
    LibraryScreen()
}