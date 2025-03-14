package com.example.bookclub.screens.library_screen.utils

import androidx.annotation.DrawableRes

data class GridItemData(
    @DrawableRes val book:Int,
    val title:String,
    val author:String
)
