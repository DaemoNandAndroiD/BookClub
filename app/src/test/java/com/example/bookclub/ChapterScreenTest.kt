package com.example.bookclub

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.bookclub.screens.chapter_screen.ChapterScreen
import com.example.bookclub.screens.chapter_screen.ChapterScreenTestTags
import org.junit.Test

class ChapterScreenTest : DefaultTest() {

    @Test
    fun defaultTest(){
        composeTestRule.setContent {
            ChapterScreen(
                quote = "",
                launchChapterIndex = 0,
            ) { }
        }

        with(composeTestRule){
            onNodeWithTag(ChapterScreenTestTags.BACK_BUTTON)
                .assertIsDisplayed()

            onNodeWithTag(ChapterScreenTestTags.BOOK_TITLE)
                .assertIsDisplayed()
                .assertTextEquals("код да винчи".uppercase())

            onNodeWithTag(ChapterScreenTestTags.CHAPTER_TITLE)
                .assertIsDisplayed()
                .assertTextEquals("Факты")

            onNodeWithTag(ChapterScreenTestTags.NAVIGATE_FORWARD)
                .assertIsDisplayed()
                .performClick()

            onNodeWithTag(ChapterScreenTestTags.CHAPTER_TITLE)
                .assertIsDisplayed()
                .assertTextEquals("Пролог")

            onNodeWithTag(ChapterScreenTestTags.NAVIGATE_BACK)
                .assertIsDisplayed()
                .performClick()
                .assertIsNotEnabled()

            onNodeWithTag(ChapterScreenTestTags.CHAPTER_TITLE)
                .assertIsDisplayed()
                .assertTextEquals("Факты")

            onNodeWithTag(ChapterScreenTestTags.MENU_BUTTON)
                .assertIsDisplayed()
                .performClick()

            onNodeWithTag(ChapterScreenTestTags.SIDE_SHEET_TITLE)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.settings_side_sheet_title).uppercase())

            onAllNodesWithTag(ChapterScreenTestTags.SIDE_SHEET_ITEM)[2]
                .performClick()

            onNodeWithTag(ChapterScreenTestTags.CLOSE_SIDE_SHEET)
                .performClick()

            onNodeWithTag(ChapterScreenTestTags.CHAPTER_TITLE)
                .assertIsDisplayed()
                .assertTextEquals("Глава 1")
        }
    }
}