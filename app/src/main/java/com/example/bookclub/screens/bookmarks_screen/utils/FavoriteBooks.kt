package com.example.bookclub.screens.bookmarks_screen.utils

import com.example.bookclub.R
import com.example.bookclub.screens.library_screen.utils.GridItemData


val favoriteBooks = listOf(
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
)

fun getFavoriteBooks(items:List<GridItemData>?) = items ?: favoriteBooks