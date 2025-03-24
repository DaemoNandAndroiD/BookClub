package com.example.bookclub.screens.book_details_screen.utils

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.lazy.LazyListState

suspend fun LazyListState.customAutoScroll(
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 700, easing = LinearEasing)
){
    var previousValue = 0f
    scroll(MutatePriority.UserInput) {
        animate(0f, 24f, animationSpec = animationSpec) { currentValue, _ ->
            previousValue += scrollBy(currentValue - previousValue)
        }
    }
}