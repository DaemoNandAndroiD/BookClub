package com.example.bookclub.screens.bookmarks_screen.utils

import androidx.annotation.DrawableRes
import com.example.bookclub.R

data class ContinueReadingData(
    @DrawableRes val bookImage:Int,
    val title:String,
    val stage:String,
    val percent:Float
)

val continueReadingData = ContinueReadingData(
    R.drawable.image,
    "Код да винчи",
    "Пролог",
    percent = 60f
)

fun getContinueReadingData(item:ContinueReadingData?) = item ?: continueReadingData
