package com.example.bookclub.screens.chapter_screen

import android.widget.Space
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.interaction.collectIsDraggedAsState
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.book_details_screen.utils.ChapterData
import com.example.bookclub.screens.book_details_screen.utils.chapters
import com.example.bookclub.screens.book_details_screen.utils.customAutoScroll
import com.example.bookclub.screens.chapter_screen.components.ChapterBottomAppBar
import com.example.bookclub.screens.chapter_screen.components.MaterialSlider
import com.example.bookclub.screens.chapter_screen.components.SideSheet
import com.example.bookclub.screens.chapter_screen.utils.chaptersExt
import com.example.bookclub.screens.welcome_screen.utils.autoScroll
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.georgiaFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import com.example.bookclub.utils.parseItalic
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreen(
    launchChapterIndex: Int,
    quote:String,
    navigateBack: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    var fontSizeSliderPosition by remember { mutableFloatStateOf(14f) }
    var lineHeightSliderPosition by remember { mutableFloatStateOf(150f) }
    var paragraphPadding by remember { mutableFloatStateOf(8 / 1.5f) }

    val bottomSheetState = rememberModalBottomSheetState()
    var bottomSheetVisibility by remember { mutableStateOf(false) }

    var sideSheetVisibility by remember { mutableStateOf(false) }

    var autoScrollState by remember { mutableStateOf(false) }
    var highlightText by remember { mutableStateOf(false) }

    val chapterDataExt = chaptersExt
    var currentChapter by remember { mutableIntStateOf(launchChapterIndex) }

    var currentParagraphIndex by remember { mutableIntStateOf(-1) }
    var currentSentenceIndex by remember { mutableIntStateOf(-1) }

    val lazyColumnState = rememberLazyListState()
    val coroutineScroll = rememberCoroutineScope()

    val isFirstItemVisible by remember {
        derivedStateOf {
            lazyColumnState.firstVisibleItemIndex == 0
                    && (lazyColumnState.layoutInfo.visibleItemsInfo.firstOrNull()?.offset ?: 1) == 0
        }
    }

    val isLastItemVisible by remember {
        derivedStateOf {
            lazyColumnState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == chapterDataExt[currentChapter].content.lastIndex
        }
    }

    val sideSheetContent = chapterDataExt.mapIndexed { index, chapter ->
        ChapterData(title = chapter.chapterTitle, isActive = index == currentChapter)
    }

    val dragState = lazyColumnState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(dragState.value) {
        if(dragState.value){
            autoScrollState = false
        }
    }

    LaunchedEffect(autoScrollState) {
        if(autoScrollState){
            coroutineScroll.launch {
                if(!isFirstItemVisible){
                    lazyColumnState.animateScrollToItem(lazyColumnState.firstVisibleItemIndex, -50)
                }

                if(isFirstItemVisible){
                    delay(3000)
                }

                while (autoScrollState) {
                    lazyColumnState.customAutoScroll()
                }
            }

            for(indexParagraph in lazyColumnState.firstVisibleItemIndex..chapterDataExt[currentChapter].content.lastIndex){
                currentParagraphIndex = indexParagraph

                for (indexSentence in 0..chapterDataExt[currentChapter].content[currentParagraphIndex].lastIndex){
                    currentSentenceIndex = indexSentence
                    delay(3000)
                }
            }
        }
    }

    var backGroundAlfa by remember { mutableFloatStateOf(1f) }

    LaunchedEffect(Unit){
        if(quote.isNotEmpty()){
            loop@ for (ip in chapterDataExt[currentChapter].content.indices){
                for (iS in chapterDataExt[currentChapter].content[ip].indices){
                    if(chapterDataExt[currentChapter].content[ip][iS].contains(quote)){
                        currentParagraphIndex = ip
                        currentSentenceIndex = iS

                        break@loop
                    }
                }
            }

            lazyColumnState.animateScrollToItem(currentParagraphIndex, scrollOffset = 100)

            highlightText = true

            backGroundAlfa = 0.3f
            delay(4000)

            currentParagraphIndex = -1
            currentSentenceIndex = -1

            highlightText = false
            backGroundAlfa = 1f
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        Scaffold(
            bottomBar = {
                ChapterBottomAppBar(
                    onSettingsClick = {
                        bottomSheetVisibility = true
                    },
                    onMenuClick = {
                        sideSheetVisibility = true
                    },
                    onPreviousClick = {
                        currentChapter--
                    },
                    onNextClick = {
                        currentChapter++
                    },
                    onFabClick = {
                        autoScrollState = !autoScrollState
                    },
                    isPreviousEnabled = currentChapter != 0,
                    isNextEnabled = currentChapter != chapterDataExt.lastIndex,
                    fabState = autoScrollState
                )
            }

        ) { paddingValue ->
            Column(
                modifier = Modifier
                    .background(colorResource(R.color.background))
                    .padding(bottom = paddingValue.calculateBottomPadding() + 16.dp)
                    .fillMaxSize()
                    .statusBarsPadding()
                    .systemBarsPadding()
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
                            .testTag(ChapterScreenTestTags.BACK_BUTTON)
                            .align(Alignment.CenterVertically)
                            .background(colorResource(R.color.accent_dark), CircleShape),
                        onClick = navigateBack
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
                            text = chapterDataExt[currentChapter].bookTitle.uppercase(Locale.getDefault()),
                            textAlign = TextAlign.Center,
                            fontFamily = alumniSansFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = colorResource(R.color.accent_dark),
                            modifier = Modifier.testTag(ChapterScreenTestTags.BOOK_TITLE)
                        )

                        Text(
                            text = chapterDataExt[currentChapter].chapterTitle,
                            modifier = Modifier.align(Alignment.CenterHorizontally).testTag(ChapterScreenTestTags.CHAPTER_TITLE),
                            fontFamily = velaSansFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = colorResource(R.color.accent_dark),
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
                ) {
                    SelectionContainer {
                        LazyColumn(
                            state = lazyColumnState
                        ) {
                            itemsIndexed(chapterDataExt[currentChapter].content) { indexParent, p ->
                                Text(
                                    modifier = Modifier.padding(
                                        top = if (indexParent == 0) 0.dp else (paragraphPadding * (lineHeightSliderPosition / 100)).dp
                                    ),
                                    text = buildAnnotatedString{
                                        p.forEachIndexed { indexChild, s ->
                                            withStyle(
                                                style = SpanStyle(
                                                    color = if(indexChild == currentSentenceIndex && indexParent == currentParagraphIndex && (autoScrollState|| highlightText)) colorResource(R.color.red_secondary) else colorResource(R.color.black).copy(alpha = backGroundAlfa)
                                                )
                                            ){
                                                append(parseItalic(s))
                                            }
                                            append(" ")
                                        }
                                    },
                                    fontFamily = georgiaFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontStyle = FontStyle.Normal,
                                    fontSize = fontSizeSliderPosition.sp,
                                    lineHeight = fontSizeSliderPosition.sp * (lineHeightSliderPosition / 100),
                                )
                            }
                        }
                    }


                    if (!isFirstItemVisible) {
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
                    }

                    if (!isLastItemVisible) {
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
            }

            if (bottomSheetVisibility) {
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
                                text = stringResource(R.string.settings_bottom_sheet_title).uppercase(
                                    Locale.getDefault()
                                ),
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
                                initalValue = lineHeightSliderPosition,
                                startValue = 100f,
                                endValue = 200f,
                                onValueChange = {
                                    lineHeightSliderPosition = it
                                }
                            )
                        }
                    }
                }
            }
        }

        if (sideSheetVisibility) {
            SideSheet(
                sideSheetWidth = screenWidth * 0.77f,
                isDrawerOpen = sideSheetVisibility,
                content = sideSheetContent,
                onDismiss = {
                    sideSheetVisibility = false
                },
                onItemClick = {
                    currentChapter = it
                }
            )
        }
    }
}

@Preview
@Composable
fun qqqweqw() {
    ChapterScreen(1, "Я все еще жив") { }
}
