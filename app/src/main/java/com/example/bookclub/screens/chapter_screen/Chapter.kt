package com.example.bookclub.screens.chapter_screen

import kotlinx.serialization.Serializable

@Serializable
data class Chapter(
    val chapterIndex:Int = 0,
    val quote:String = ""
)