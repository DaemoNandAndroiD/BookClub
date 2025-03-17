package com.example.bookclub.screens.chapter_screen

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.book_details_screen.utils.chapters
import com.example.bookclub.screens.chapter_screen.components.ChapterBottomAppBar
import com.example.bookclub.screens.chapter_screen.components.MaterialSlider
import com.example.bookclub.screens.chapter_screen.components.SideSheet
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreen(){
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var fontSizeSliderPosition by remember { mutableFloatStateOf(14f) }

    val bottomSheetState  = rememberModalBottomSheetState()
    var bottomSheetVisibility by remember { mutableStateOf(false) }

    var sideSheetVisibility by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize().background(colorResource(R.color.background))
    ){
        Scaffold(
            bottomBar = {
                ChapterBottomAppBar(
                    onSettingsClick = {
                        bottomSheetVisibility = true
                    },
                    onMenuClick = {
                        sideSheetVisibility = true
                    }
                )
            }

        ) {paddingValue->
            Column(
                modifier = Modifier
                    .background(colorResource(R.color.background))
                    .padding(bottom = paddingValue.calculateBottomPadding() + 16.dp)
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .padding(
                            vertical = dimensionResource(R.dimen.small_startend_padding),
                            horizontal = dimensionResource(R.dimen.small_startend_padding)
                        )
                        .fillMaxWidth()
                        .wrapContentHeight()

                ) {
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .background(colorResource(R.color.accent_dark), CircleShape),
                        onClick = {}
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            tint = colorResource(R.color.white)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "код да винчи".uppercase(Locale.getDefault()),
                            textAlign = TextAlign.Center,
                            fontFamily = alumniSansFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = colorResource(R.color.accent_dark)
                        )

                        Text(
                            text = "Пролог",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontFamily = velaSansFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = colorResource(R.color.accent_dark)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 20.dp)
                            .background(Color.Transparent, CircleShape),
                        onClick = {}
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            tint = Color.Transparent
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = dimensionResource(R.dimen.small_startend_padding),
                            end = dimensionResource(R.dimen.small_startend_padding),
                        )
                ){
                    LazyColumn{
                        item{
                            Text(
                                text = stringResource(R.string.test_text),
                                fontFamily = velaSansFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = fontSizeSliderPosition.sp,
                                color = colorResource(R.color.black)
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f)
                            .align(Alignment.TopCenter)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        colorResource(R.color.background),
                                        colorResource(R.color.background).copy(alpha = 0f)
                                    )
                                ),
                            )
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f)
                            .align(Alignment.BottomCenter)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        colorResource(R.color.background).copy(alpha = 0f),
                                        colorResource(R.color.background)
                                    )
                                ),
                            )
                    )
                }
            }

            if(bottomSheetVisibility){
                ModalBottomSheet(
                    onDismissRequest = {
                        bottomSheetVisibility = false
                    },
                    containerColor = colorResource(R.color.background),
                    sheetState = bottomSheetState,
                    dragHandle = null
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(28.dp),
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.small_startend_padding),
                            end = dimensionResource(R.dimen.small_startend_padding),
                            top = 16.dp,
                            bottom = 20.dp
                        )
                    ) {
                        Row {
                            Text(
                                text = stringResource(R.string.settings_bottom_sheet_title).uppercase(Locale.getDefault()),
                                fontFamily = alumniSansFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                modifier = Modifier.align(Alignment.CenterVertically),
                                color = colorResource(R.color.accent_dark)
                            )

                            Spacer(Modifier.weight(1f))

                            IconButton(
                                modifier = Modifier
                                    .background(Color.Transparent),
                                onClick = {
                                    bottomSheetVisibility = false
                                }
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = null,
                                    tint = colorResource(R.color.accent_dark)
                                )
                            }
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.font_size_header),
                                fontFamily = velaSansFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = colorResource(R.color.accent_dark)
                            )

                            MaterialSlider(
                                initalValue = fontSizeSliderPosition,
                                startValue = 8f,
                                endValue = 20f,
                                onValueChange = {
                                    fontSizeSliderPosition = it
                                }
                            )
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.line_spacing_header),
                                fontFamily = velaSansFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = colorResource(R.color.accent_dark)
                            )

                            MaterialSlider(
                                initalValue = fontSizeSliderPosition,
                                startValue = 8f,
                                endValue = 20f,
                                onValueChange = {}
                            )
                        }
                    }
                }
            }
        }

        if(sideSheetVisibility){
            SideSheet(
                sideSheetWidth = screenWidth * 0.77f,
                isDrawerOpen = sideSheetVisibility,
                content = chapters,
                onDismiss = {
                    sideSheetVisibility = false
                }
            )
        }
    }
}


@Preview
@Composable
fun ChapterScreenPreview(){
    ChapterScreen()
}