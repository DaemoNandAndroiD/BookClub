package com.example.bookclub.screens.library_screen.utils

import androidx.annotation.DrawableRes
import com.example.bookclub.R

data class GridItemData(
    @DrawableRes val book:Int,
    val title:String,
    val author:String
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

fun getItemsGrid(items:List<GridItemData>?) = items ?: itemsGrid

