package com.example.bookclub

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToIndex
import com.example.bookclub.screens.book_details_screen.BookDetailsScreen
import com.example.bookclub.screens.book_details_screen.BookDetailsScreenTestTag
import com.example.bookclub.screens.book_details_screen.utils.BookDetailsData
import com.example.bookclub.screens.book_details_screen.utils.ChapterData
import com.example.bookclub.screens.book_details_screen.utils.description
import com.example.bookclub.utils.parseParagraph
import org.junit.Test

class BookDetailsScreenTest : DefaultTest() {

    @Test
    fun filledTest(){
        composeTestRule.setContent {
            BookDetailsScreen(
                navigateBack = {},
                onRead = {}
            )
        }

        with(composeTestRule){
            onNodeWithTag(BookDetailsScreenTestTag.BACK_BUTTON)
                .assertIsDisplayed()

            onNodeWithTag(BookDetailsScreenTestTag.BOOK_IMAGE)
                .assertIsDisplayed()


            onNodeWithTag(BookDetailsScreenTestTag.READ_BUTTON)
                .assertIsDisplayed()

            onNodeWithTag(BookDetailsScreenTestTag.BOOKMARK_BUTTON)
                .assertIsDisplayed()


            onNodeWithTag(BookDetailsScreenTestTag.TITLE_LARGE)
                .assertTextEquals(bookDetailsData.title.uppercase())

            onNodeWithTag(BookDetailsScreenTestTag.TITLE_SMALL)
                .assertTextEquals(bookDetailsData.author)

            onNodeWithTag(BookDetailsScreenTestTag.SCROLL_CONT)
                .performScrollToIndex(7)

            onNodeWithTag(BookDetailsScreenTestTag.PROGRESS_SECTION_TITLE)
                .assertTextEquals(resources.getString(R.string.progress_section_title).uppercase())

            onNodeWithTag(BookDetailsScreenTestTag.BOOK_PROGRESS)
                .assertIsDisplayed()

            onNodeWithTag(BookDetailsScreenTestTag.CHAPTERS_SECTION_TITLE)
                .assertTextEquals(resources.getString(R.string.chapters_section_title).uppercase())

            onNodeWithTag(BookDetailsScreenTestTag.SCROLL_CONT)
                .performScrollToIndex(17)

            onAllNodesWithTag(BookDetailsScreenTestTag.CHAPTER_ITEM)
                .assertCountEquals(8)

            onNodeWithTag(BookDetailsScreenTestTag.SCROLL_CONT)
                .performScrollToIndex(25)

            onAllNodesWithTag(BookDetailsScreenTestTag.CHAPTER_ITEM)
                .assertCountEquals(8)
        }
    }

    @Test fun emptyProgressBar(){
        composeTestRule.setContent {
            BookDetailsScreen(
                data = bookDetailsData,
                navigateBack = {},
                onRead = {}
            )
        }

        with(composeTestRule){
            onNodeWithTag(BookDetailsScreenTestTag.SCROLL_CONT)
                .performScrollToIndex(7)

            onNodeWithTag(BookDetailsScreenTestTag.PROGRESS_SECTION_TITLE)
                .assertIsNotDisplayed()

            onNodeWithTag(BookDetailsScreenTestTag.BOOK_PROGRESS)
                .assertIsNotDisplayed()
        }
    }
}

val chapters = listOf(
    ChapterData("Факты", false, false),
    ChapterData("Пролог", false, true),
    ChapterData("Глава 1", false, false),
    ChapterData("Глава 2", false, false),
    ChapterData("Глава 3", false, false),
    ChapterData("Глава 4", false, false),
    ChapterData("Глава 5", false, false),
    ChapterData("Глава 6", false, false),
    ChapterData("Глава 7", false, false),
    ChapterData("Глава 8", false, false),
    ChapterData("Глава 9", false, false),
    ChapterData("Глава 10", false, false),
    ChapterData("Глава 11", false, false),
    ChapterData("Глава 12", false, false),
    ChapterData("Глава 13", false, false),
)

val bookDetailsData = BookDetailsData(
    imageBackground = R.drawable.img_backgroundbook,
    isFavorite = false,
    title = "Код да винчи",
    author = "Дэн Браун",
    description = description.parseParagraph(),
    percent = 0f,
    chapters = chapters
)