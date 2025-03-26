package com.example.bookclub.screens.search_screen.components

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.bookclub.R
import com.example.bookclub.screens.library_screen.utils.GridItemData
import com.example.bookclub.screens.search_screen.utils.Author

val recentTexts = listOf("iOS", "Android", "Тихий дэн")

val searchResults = listOf(
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
)

val genresTexts = listOf(
    "Классика",
    "Фэнтези",
    "Фантастика",
    "Детектив",
    "Триллер",
    "Исторический роман",
    "Любовный роман",
    "Приключения",
    "Поэзия",
    "Биография",
    "Для подростков",
    "Для детей",
)

val authors = listOf(
    Author(R.drawable.author_image1, "Братья Стругацкие"),
    Author(R.drawable.author_image1, "Братья Стругацкие"),
    Author(R.drawable.author_image1, "Братья Стругацкие"),
    Author(R.drawable.author_image1, "Братья Стругацкие"),
)

fun getRecentTexts(items:List<String>?) = items ?: recentTexts

fun getSearchResults(items: List<GridItemData>?) = items ?: searchResults

fun getGenresTexts(itemData: List<String>?) = itemData ?: genresTexts

fun getAuthors(items:List<Author>?) = items ?: authors