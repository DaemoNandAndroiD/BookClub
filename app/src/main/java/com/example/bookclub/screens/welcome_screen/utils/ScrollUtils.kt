package com.example.bookclub.screens.welcome_screen.utils

import android.util.Log
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.util.UUID

data class ListItem(
    val id: String = UUID.randomUUID().toString(),
    val res:Int
)


@Composable
fun AutoScrollingLazyRow(
    list: List<ListItem>,
    modifier: Modifier = Modifier,
    itemContent: @Composable (item: Int) -> Unit,
    lazyListState: LazyListState
) {
    LaunchedEffect(Unit) {
        while (true) {
            lazyListState.autoScroll()
        }
    }

    var items by remember { mutableStateOf(list.mapListToFit()) }

    LazyRow(
        state = lazyListState,
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(
            items, key = { _, item -> item.id }
        ) { index, item ->
            itemContent(item.res)

            if (index == items.lastIndex) {
                items = items.subList(lazyListState.firstVisibleItemIndex, items.size) + items.subList(0, lazyListState.firstVisibleItemIndex)
            }
        }
    }
}

fun List<ListItem>.mapListToFit() : List<ListItem>{
    val newList = this.toMutableList()

    while (newList.size < 6){
        this.forEach {
            newList.add(ListItem(res = it.res))
        }
    }

    return newList
}

suspend fun ScrollableState.autoScroll(
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 500, easing = LinearEasing)
) {
    var previousValue = 0f
    scroll(MutatePriority.PreventUserInput) {
        animate(0f, 204f, animationSpec = animationSpec) { currentValue, _ ->
            previousValue += scrollBy(currentValue - previousValue)
        }
    }
}