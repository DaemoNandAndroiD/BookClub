package com.example.bookclub.screens.book_details_screen.utils

import androidx.annotation.DrawableRes
import com.example.bookclub.R

data class BookDetailsData(
    @DrawableRes val imageBackground:Int,
    val isFavorite:Boolean,
    val title:String,
    val author:String,
    val description:String,
    val percent:Float,
    val chapters:List<ChapterData>
)

val description = "Секретный код скрыт в работах Леонардо да Винчи...\n" +
        "Только он поможет найти христианские святыни, дающие немыслимые власть и могущество... \n" +
        "Ключ к величайшей тайне, над которой человечество билось веками, наконец может быть найден..."

val chapters = listOf(
    ChapterData("Факты", true, false),
    ChapterData("Пролог", false, true),
    ChapterData("Глава 1", false, false),
    ChapterData("Глава 2", false, false),
    ChapterData("Глава 3", false, false),
    ChapterData("Глава 4", false, false),
    ChapterData("Глава 5", false, false),
    ChapterData("Глава 6", false, false),
    ChapterData("Глава 7", false, false),
    ChapterData("Глава 8", false, false),
    ChapterData("Глава 10", false, false),
    ChapterData("Глава 11", false, false),
    ChapterData("Глава 12", false, false),
    ChapterData("Глава 13", false, false),
)

val bookDetailsData = BookDetailsData(
    imageBackground = R.drawable.img_backgroundbook,
    isFavorite = false,
    title = "Код да винчи",
    author = "Дэн Браун",
    description = description,
    percent = 20f,
    chapters = chapters
)