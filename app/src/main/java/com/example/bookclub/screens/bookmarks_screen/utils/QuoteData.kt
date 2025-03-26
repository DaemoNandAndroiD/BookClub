package com.example.bookclub.screens.bookmarks_screen.utils

data class QuoteData(
    val quote:String,
    val bookTitle:String,
    val author: String,
    val chapterIndex:Int
)

val quotes = listOf(
    QuoteData("Я все еще жив", "Код да винчи", "Дэн Браун", chapterIndex = 1),
    QuoteData("умерщвления плоти", "Код да винчи", "Дэн Браун", chapterIndex = 0),
    QuoteData("Ты не должен бежать", "Код да винчи", "Дэн Браун", chapterIndex = 4)
)

fun getQuotes(items: List<QuoteData>?) = items ?: quotes