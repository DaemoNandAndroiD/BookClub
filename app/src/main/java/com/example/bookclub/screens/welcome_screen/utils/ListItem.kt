package com.example.bookclub.screens.welcome_screen.utils

import java.util.UUID

data class ListItem(
    val id: String = UUID.randomUUID().toString(),
    val res:Int
)

