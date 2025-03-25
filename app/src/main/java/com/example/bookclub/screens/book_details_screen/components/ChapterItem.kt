package com.example.bookclub.screens.book_details_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.book_details_screen.utils.ChapterData
import com.example.bookclub.screens.book_details_screen.utils.description
import com.example.bookclub.ui.theme.velaSansFontFamily

@Composable
fun ChapterItem(
    modifier: Modifier = Modifier,
    chapterData: ChapterData,
    onClick:()->Unit
){
    Row(
        modifier = modifier.fillMaxWidth().clickable { onClick() }
    ) {
        Text(
            modifier = Modifier
                .padding(
                    vertical = 14.dp
                ),
            text = chapterData.title,
            fontSize = 16.sp,
            fontFamily = velaSansFontFamily,
            fontWeight = if(!chapterData.isActive) FontWeight.Normal else FontWeight.Bold,
            color = colorResource(R.color.accent_dark)
        )

        Spacer(modifier = Modifier.weight(1f))

        if (chapterData.isDone){
            Icon(
                ImageVector.vectorResource(R.drawable.ic_done),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically),
                tint = colorResource(R.color.accent_medium)
            )
        }
        else if (chapterData.isActive){
            Icon(
                ImageVector.vectorResource(R.drawable.ic_current_chapter),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically),
                tint = colorResource(R.color.accent_dark)
            )
        }
    }
}