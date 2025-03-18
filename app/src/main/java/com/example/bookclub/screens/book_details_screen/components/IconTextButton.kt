package com.example.bookclub.screens.book_details_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.ui.theme.velaSansFontFamily

@Composable
fun IconTextButton(
    contentColor:Int,
    containerColor:Int,
    textContent:String,
    textIcon:Int,
    onClick:()->Unit,
    modifier: Modifier = Modifier
){
    val text = buildAnnotatedString {
        appendInlineContent("inlineContent")
        append(textContent)
    }

    val inlineContent = mapOf(
        Pair(
            "inlineContent",
            InlineTextContent(
                placeholder = Placeholder(
                    width = 1.5.em,
                    height = 1.em,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                ),
                children = {
                    Icon(
                        ImageVector.vectorResource(textIcon),
                        contentDescription = null,
                        tint = colorResource(contentColor)
                    )
                }
            )
        )
    )

    TextButton(
        modifier = modifier.background(colorResource(containerColor), CircleShape),
        onClick = onClick,
    ) {
        Text(
            text = text,
            inlineContent = inlineContent,
            fontSize = 14.sp,
            fontFamily = velaSansFontFamily,
            fontWeight = FontWeight.Bold,
            color = colorResource(contentColor)
        )
    }
}