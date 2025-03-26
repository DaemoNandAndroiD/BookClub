package com.example.bookclub

import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToIndex
import com.example.bookclub.screens.bookmarks_screen.BookMarksScreenTestTag
import com.example.bookclub.screens.bookmarks_screen.BookmarksScreen
import com.example.bookclub.screens.bookmarks_screen.utils.ContinueReadingData
import com.example.bookclub.screens.bookmarks_screen.utils.QuoteData
import com.example.bookclub.screens.library_screen.utils.GridItemData
import org.junit.Test

class BookMarksScreenTest : DefaultTest() {

    @Test
    fun emptyTest() {
        composeTestRule.setContent {
            BookmarksScreen(
                continueReading = null,
                favoriteBooksData = listOf(),
                quoteData = listOf(),
                onChapterNavigate = {},
                onChapterWithQuoteNavigate = { i: Int, s: String -> Unit },
                onBookDetailsNavigate = {}
            )
        }

        with(composeTestRule) {
            onNodeWithTag(BookMarksScreenTestTag.title)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.bookmarks_title).uppercase())

            onNodeWithTag(BookMarksScreenTestTag.readingBtn)
                .assertIsNotDisplayed()

            onNodeWithTag(BookMarksScreenTestTag.readingNowCategory)
                .assertIsNotDisplayed()

            onNodeWithTag(BookMarksScreenTestTag.readingNowBook)
                .assertIsNotDisplayed()

            onNodeWithTag(BookMarksScreenTestTag.favoritesCategory)
                .assertIsNotDisplayed()

            onNodeWithTag(BookMarksScreenTestTag.quotesCategory)
                .assertIsNotDisplayed()
        }
    }

    @Test
    fun testWithData() {
        composeTestRule.setContent {
            BookmarksScreen(
                favoriteBooksData = listOf(
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                ),
                quoteData = listOf(
                    QuoteData("Я все еще жив", "Код да винчи", "Дэн Браун", chapterIndex = 1),
                    QuoteData("умерщвления плоти", "Код да винчи", "Дэн Браун", chapterIndex = 0),
                    QuoteData("Ты не должен бежать", "Код да винчи", "Дэн Браун", chapterIndex = 4)
                ),
                onChapterNavigate = {},
                onChapterWithQuoteNavigate = { i: Int, s: String -> Unit },
                onBookDetailsNavigate = {}
            )
        }

        with(composeTestRule) {
            onNodeWithTag(BookMarksScreenTestTag.title)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.bookmarks_title).uppercase())

            onNodeWithTag(BookMarksScreenTestTag.readingBtn)
                .assertIsDisplayed()
                .assertIsEnabled()

            onNodeWithTag(BookMarksScreenTestTag.readingNowCategory)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.read_now_category).uppercase())

            onNodeWithTag(BookMarksScreenTestTag.readingNowBook)
                .assertIsDisplayed()

            onNodeWithTag(BookMarksScreenTestTag.bookReadingNowTitle, useUnmergedTree = true)
                .assertIsDisplayed()
                .assertTextEquals("Код да винчи".uppercase())

            onNodeWithTag(BookMarksScreenTestTag.bookReadingNowStage, useUnmergedTree = true)
                .assertIsDisplayed()
                .assertTextEquals("Пролог")

            onNodeWithTag(BookMarksScreenTestTag.favoritesCategory)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.favorite_books_category).uppercase())

            onNodeWithTag(BookMarksScreenTestTag.scrollCont)
                .performScrollToIndex(4)

            onAllNodesWithTag(BookMarksScreenTestTag.favoritesItem)
                .assertCountEquals(5)

            onNodeWithTag(BookMarksScreenTestTag.scrollCont)
                .performScrollToIndex(7)

            onNodeWithTag(BookMarksScreenTestTag.quotesCategory)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.quotes_category).uppercase())

            onAllNodesWithTag(BookMarksScreenTestTag.quoteItem)
                .assertCountEquals(3)
        }
    }
}