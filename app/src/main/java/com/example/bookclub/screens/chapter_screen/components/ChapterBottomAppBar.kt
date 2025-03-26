package com.example.bookclub.screens.chapter_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookclub.R
import com.example.bookclub.screens.chapter_screen.ChapterScreenTestTags

@Composable
fun ChapterBottomAppBar(
    onSettingsClick:()->Unit,
    onMenuClick:()->Unit,
    onPreviousClick:()->Unit,
    onNextClick:()->Unit,
    onFabClick:()->Unit,
    isPreviousEnabled:Boolean,
    isNextEnabled:Boolean,
    fabState:Boolean
){

    BottomAppBar(
        containerColor = colorResource(R.color.accent_dark),
        modifier = Modifier.height(80.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxHeight().padding(start = 16.dp).offset(y = -2.dp),
        ) {
            IconButton(
                onClick = onPreviousClick,
                enabled = isPreviousEnabled,
                modifier = Modifier.testTag(ChapterScreenTestTags.NAVIGATE_BACK)
            ) {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_chapter_back),
                    contentDescription = null,
                    tint = if(isPreviousEnabled) colorResource(R.color.white) else colorResource(R.color.accent_medium)
                )
            }

            IconButton(
                onClick = onMenuClick,
                modifier = Modifier.testTag(ChapterScreenTestTags.MENU_BUTTON)
            ) {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_chapter_menu),
                    contentDescription = null,
                    tint = colorResource(R.color.white)
                )
            }

            IconButton(
                onClick = onNextClick,
                enabled = isNextEnabled,
                modifier = Modifier.testTag(ChapterScreenTestTags.NAVIGATE_FORWARD)
            ) {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_chapter_next),
                    contentDescription = null,
                    tint = if(isNextEnabled) colorResource(R.color.white) else colorResource(R.color.accent_medium)
                )
            }

            IconButton(
                onClick = onSettingsClick,
                modifier = Modifier.testTag(ChapterScreenTestTags.SETTINGS_BUTTON)
            ) {
                Icon(
                    ImageVector.vectorResource(R.drawable.ic_chapter_settings),
                    contentDescription = null,
                    tint = colorResource(R.color.white)
                )
            }

            Spacer(Modifier.weight(1f))

            FloatingActionButton(
                modifier = Modifier.padding(end = 16.dp),
                onClick = onFabClick,
                containerColor = colorResource(R.color.accent_light)
            ) {
                if(!fabState){
                    Icon(
                        ImageVector.vectorResource(R.drawable.ic_play),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 2.dp),
                        tint = colorResource(R.color.accent_dark)
                    )
                }
                else{
                    Icon(
                        ImageVector.vectorResource(R.drawable.ic_pause),
                        contentDescription = null,
                        tint = colorResource(R.color.accent_dark)
                    )
                }
            }
        }
    }
}