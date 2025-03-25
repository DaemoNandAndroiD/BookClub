package com.example.bookclub.screens.book_details_screen.utils

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.parallaxScroll(scrollState: LazyListState, rate:Float) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val height = scrollState.firstVisibleItemScrollOffset / rate

    layout(placeable.width, placeable.height){
        placeable.place(0, height.toInt())
    }
}