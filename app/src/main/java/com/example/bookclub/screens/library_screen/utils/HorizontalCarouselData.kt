package com.example.bookclub.screens.library_screen.utils

import androidx.annotation.DrawableRes
import com.example.bookclub.R

data class HorizontalCarouselData(
    @DrawableRes val book:Int,
    val description:String,
    val title:String
)

val carouselItems = listOf<HorizontalCarouselData>(
    HorizontalCarouselData(
        R.drawable.hunger_games,
        "Долгожданное продолжение «Голодных игр»",
        "рассвет жатвы"
    ),
    HorizontalCarouselData(
        R.drawable.hunger_games,
        "Долгожданное продолжение «Голодных игр»",
        "рассвет жатвы"
    ),
    HorizontalCarouselData(
        R.drawable.hunger_games,
        "Долгожданное продолжение «Голодных игр»",
        "рассвет жатвы"
    ),
    HorizontalCarouselData(
        R.drawable.hunger_games,
        "Долгожданное продолжение «Голодных игр»",
        "рассвет жатвы"
    ),
    HorizontalCarouselData(
        R.drawable.hunger_games,
        "Долгожданное продолжение «Голодных игр»",
        "рассвет жатвы"
    ),
    HorizontalCarouselData(
        R.drawable.hunger_games,
        "Долгожданное продолжение «Голодных игр»",
        "рассвет жатвы"
    )
)

fun getCarouselData(items:List<HorizontalCarouselData>?) = items ?: carouselItems
