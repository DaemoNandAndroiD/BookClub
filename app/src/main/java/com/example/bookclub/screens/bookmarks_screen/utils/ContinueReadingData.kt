package com.example.bookclub.screens.bookmarks_screen.utils

import androidx.annotation.DrawableRes

data class ContinueReadingData(
    @DrawableRes val bookImage:Int,
    val title:String,
    val stage:String,
    val percent:Float
)
