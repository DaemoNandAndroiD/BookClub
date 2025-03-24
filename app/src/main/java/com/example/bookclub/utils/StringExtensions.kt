package com.example.bookclub.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle

fun String.parseParagraph():List<String>{
    return this.split('\n')
}

fun String.parseSentences():List<List<String>>{
    val paragraphs = this.split('\n')
    val sentenceRegex = Regex("(?<=[.!?])\\s+")
    return paragraphs.map { it.split(sentenceRegex).map { sentence -> sentence.trim() } }
}

fun parseItalic(input: String): AnnotatedString {
    val regex = "<i>(.*?)</i>".toRegex()
    return buildAnnotatedString {
        var lastIndex = 0
        regex.findAll(input).forEach { match ->
            val range = match.range
            append(input.substring(lastIndex, range.first))
            pushStyle(SpanStyle(fontStyle = FontStyle.Italic))
            append(match.groupValues[1])
            pop()
            lastIndex = range.last + 1
        }
        append(input.substring(lastIndex))
    }
}