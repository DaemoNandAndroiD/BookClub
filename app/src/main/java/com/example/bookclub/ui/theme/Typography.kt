package com.example.bookclub.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.bookclub.R

private val boldAlumniSans = Font(R.font.alumnisans_bold, FontWeight.Bold)

private val boldVelaSans = Font(R.font.velasans_bold, FontWeight.Bold)
private val normalVelaSans = Font(R.font.velasans_regular, FontWeight.Normal)

private val georgiaNormal = Font(R.font.georgia_regular, FontWeight.Normal)
private val georgiaItalic = Font(R.font.georgiai,FontWeight.Normal, FontStyle.Italic)

val alumniSansFontFamily = FontFamily(boldAlumniSans)
val velaSansFontFamily = FontFamily(boldVelaSans, normalVelaSans)
val georgiaFontFamily = FontFamily(georgiaNormal, georgiaItalic)