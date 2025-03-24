package com.example.bookclub.screens.chapter_screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.book_details_screen.utils.ChapterData
import com.example.bookclub.screens.book_details_screen.utils.chapters
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun SideSheet(
    sideSheetWidth: Dp,
    isDrawerOpen: Boolean,
    content: List<ChapterData>,
    onDismiss:()->Unit,
    onItemClick:(Int)->Unit
){
    var localVisibility by remember { mutableStateOf(isDrawerOpen) }

    val density = LocalDensity.current

    val drawerWidthPx = with(density) { sideSheetWidth.toPx() }

    val offsetX = remember { Animatable(drawerWidthPx) }

    LaunchedEffect(localVisibility) {
        if (localVisibility) {
            offsetX.snapTo(drawerWidthPx)
            offsetX.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
        } else {
            offsetX.snapTo(0f)
            offsetX.animateTo(
                targetValue = drawerWidthPx,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
            onDismiss()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.black).copy(0.3f))
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localVisibility = false
                })
            }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .width(sideSheetWidth)
                .padding(bottom = 24.dp)
                .statusBarsPadding()
                .align(Alignment.CenterEnd)
                .offset { IntOffset(x = offsetX.value.roundToInt(), y = 0) }
                .background(
                    color = colorResource(R.color.background),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        bottomStart = 16.dp
                    )
                )
        ) {
            item {
                Row(
                    modifier = Modifier.padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 8.dp
                    )
                ) {
                    Text(
                        text = stringResource(R.string.settings_side_sheet_title).uppercase(Locale.getDefault()),
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
                            localVisibility = false
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = null,
                            tint = colorResource(R.color.accent_dark)
                        )
                    }
                }
            }

            items(content.size){
                Text(
                    modifier = Modifier.padding(vertical = 14.dp, horizontal = 16.dp).clickable { onItemClick(it) },
                    text = content[it].title,
                    fontFamily = velaSansFontFamily,
                    color = colorResource(R.color.accent_dark),
                    fontSize = 16.sp,
                    fontWeight = if (content[it].isActive) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}