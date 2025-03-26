package com.example.bookclub

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import com.example.bookclub.screens.library_screen.utils.GridItemData
import com.example.bookclub.screens.search_screen.SearchScreen
import com.example.bookclub.screens.search_screen.SearchScreenTestTags
import com.example.bookclub.screens.search_screen.utils.Author
import org.junit.Test

class SearchScreenTest : DefaultTest() {
    @Test
    fun emptyTest() {
        composeTestRule.setContent {
            SearchScreen(
                recentTextsData = listOf(),
                searchResultsData = listOf(),
                genresData = listOf(),
                authorsData = listOf(),
                onBookDetailsNavigate = {},
                onHideNavBar = {}
            )
        }

        with(composeTestRule) {
            onNodeWithTag(SearchScreenTestTags.SEARCH_BAR_PLACEHOLDER, true)
                .assertTextEquals(resources.getString(R.string.search_hint))

            onNodeWithTag(SearchScreenTestTags.SEARCH_BAR)
                .assertIsDisplayed()
                .performClick()

            onAllNodesWithTag(SearchScreenTestTags.SEARCH_RESULT)
                .assertCountEquals(0)

            onNodeWithTag(SearchScreenTestTags.SEARCH_BACK_BUTTON, true)
                .assertIsDisplayed()
                .performClick()

            onNodeWithTag(SearchScreenTestTags.RECENT_CATEGORY)
                .assertIsNotDisplayed()

            onAllNodesWithTag(SearchScreenTestTags.RECENT_ITEM)
                .assertCountEquals(0)

            onNodeWithTag(SearchScreenTestTags.GENRES_CATEGORY)
                .assertIsNotDisplayed()

            onAllNodesWithTag(SearchScreenTestTags.GENRE_ITEM)
                .assertCountEquals(0)

            onNodeWithTag(SearchScreenTestTags.AUTHORS_CATEGORY)
                .assertIsNotDisplayed()

            onAllNodesWithTag(SearchScreenTestTags.AUTHOR_ITEM)
                .assertCountEquals(0)
        }
    }

    @Test
    fun filledTest() {
        composeTestRule.setContent {
            SearchScreen(
                recentTextsData = listOf("iOS"),
                searchResultsData = listOf(
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                    GridItemData(R.drawable.image, "Код да винчи", "Дэн Браун"),
                ),
                genresData = listOf(
                    "Классика",
                    "Фэнтези"
                ),
                authorsData = listOf(
                    Author(R.drawable.author_image1, "Братья Стругацкие"),
                    Author(R.drawable.author_image1, "Братья Стругацкие")
                ),
                onBookDetailsNavigate = {},
                onHideNavBar = {}
            )
        }

        with(composeTestRule) {
            onNodeWithTag(SearchScreenTestTags.SEARCH_BAR_PLACEHOLDER, true)
                .assertTextEquals(resources.getString(R.string.search_hint))

            onNodeWithTag(SearchScreenTestTags.RECENT_CATEGORY)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.recent_category).uppercase())

            onAllNodesWithTag(SearchScreenTestTags.RECENT_ITEM)
                .assertCountEquals(1)

            onNodeWithTag(SearchScreenTestTags.GENRES_CATEGORY)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.genres_category).uppercase())

            onAllNodesWithTag(SearchScreenTestTags.GENRE_ITEM)
                .assertCountEquals(2)

            onNodeWithTag(SearchScreenTestTags.AUTHORS_CATEGORY)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.authors_category).uppercase())

            onNodeWithTag(SearchScreenTestTags.SCROLL_COLUMN)
                .performScrollToIndex(5)

            onAllNodesWithTag(SearchScreenTestTags.AUTHOR_ITEM)
                .assertCountEquals(2)
                .get(0)
                .performClick()

            onNodeWithTag(SearchScreenTestTags.SEARCH_BAR_FIELD, true)
                .assertTextEquals("Братья Стругацкие")

            onAllNodesWithTag(SearchScreenTestTags.SEARCH_RESULT)
                .assertCountEquals(5)

            onNodeWithTag(SearchScreenTestTags.SEARCH_BACK_BUTTON, true)
                .assertIsDisplayed()
                .performClick()
        }
    }

}