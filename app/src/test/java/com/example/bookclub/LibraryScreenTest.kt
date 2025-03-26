package com.example.bookclub

import android.content.res.Resources
import android.util.Log
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.onSiblings
import androidx.compose.ui.test.printToLog
import androidx.test.platform.app.InstrumentationRegistry
import com.example.bookclub.screens.library_screen.LibraryScreen
import com.example.bookclub.screens.library_screen.LibraryScreenTestTags
import com.example.bookclub.screens.library_screen.utils.GridItemData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

class LibraryScreenTest : DefaultTest() {

    @Test
    fun emptyTest() {
        composeTestRule.setContent {
            LibraryScreen(
                horizontalCarouselData = listOf(),
                gridItems = listOf()
            ) {}
        }

        with(composeTestRule) {
            onNodeWithTag(LibraryScreenTestTags.screenTitle)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.library_title))

            onNodeWithTag(LibraryScreenTestTags.newCategory)
                .assertIsNotDisplayed()

            onNodeWithTag(LibraryScreenTestTags.carousel)
                .assertIsNotDisplayed()
        }
    }

    @Test
    fun testWithData() {
        composeTestRule.setContent {
            LibraryScreen(
                gridItems = listOf(
                    GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
                    GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун"),
                    GridItemData(R.drawable.image, title = "Код да винчи", author = "Дэн Браун")
                )
            ) {}
        }

        with(composeTestRule) {
            onNodeWithTag(LibraryScreenTestTags.screenTitle)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.library_title))

            onNodeWithTag(LibraryScreenTestTags.newCategory)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.new_small_title))

            onNodeWithTag(LibraryScreenTestTags.carousel)
                .assertIsDisplayed()

            onNodeWithTag(LibraryScreenTestTags.popularCategory)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.popular_small_title))

            onAllNodesWithTag(LibraryScreenTestTags.popularItem, true)
                .assertCountEquals(3)
        }
    }
}