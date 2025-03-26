package com.example.bookclub

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.bookclub.screens.book_details_screen.BookDetailsScreenTestTag
import com.example.bookclub.screens.bookmarks_screen.BookMarksScreenTestTag
import com.example.bookclub.screens.bottom_navigation_screen.MainScreenTestTags
import com.example.bookclub.screens.chapter_screen.ChapterScreenTestTags
import com.example.bookclub.screens.library_screen.LibraryScreenTestTags
import com.example.bookclub.screens.navigation.AppNavHost
import com.example.bookclub.screens.search_screen.SearchScreenTestTags
import com.example.bookclub.screens.welcome_screen.WelcomeScreenTestTags
import org.junit.Test

class GeneralTest : DefaultTest() {
    @Test
    fun happyPass(){
        composeTestRule.setContent {
            AppNavHost()
        }

        with(composeTestRule){
            onNodeWithTag(testTag = WelcomeScreenTestTags.loginInput)
                .assertIsDisplayed()
                .performClick()
                .performTextInput("login")

            onNodeWithTag(testTag = WelcomeScreenTestTags.passwordInput)
                .assertIsDisplayed()
                .performClick()
                .performTextInput("password")

            onNodeWithTag(testTag = WelcomeScreenTestTags.enterBtn)
                .assertIsEnabled()
                .performClick()

            onNodeWithTag(LibraryScreenTestTags.screenTitle)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.library_title))

            onNodeWithTag(MainScreenTestTags.BOOKMARKS_NAV)
                .assertIsDisplayed()
                .performClick()

            onNodeWithTag(BookMarksScreenTestTag.title)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.bookmarks_title).uppercase())

            onNodeWithTag(BookMarksScreenTestTag.readingBtn)
                .performClick()

            onNodeWithTag(ChapterScreenTestTags.BACK_BUTTON)
                .performClick()

            onNodeWithTag(BookMarksScreenTestTag.readingNowBook)
                .performClick()

            onNodeWithTag(BookDetailsScreenTestTag.READ_BUTTON)
                .performClick()

            onNodeWithTag(ChapterScreenTestTags.CHAPTER_TITLE)
                .assertIsDisplayed()

            onNodeWithTag(ChapterScreenTestTags.BACK_BUTTON)
                .performClick()

            onNodeWithTag(BookDetailsScreenTestTag.BACK_BUTTON)
                .performClick()

            onNodeWithTag(MainScreenTestTags.LOGOUT_NAV)
                .assertIsDisplayed()
                .performClick()

            onNodeWithTag(MainScreenTestTags.DIALOG_CONFIRM, true)
                .performClick()

            onNodeWithTag(testTag = WelcomeScreenTestTags.smallHeader)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.small_title_welcome))

            onNodeWithTag(testTag = WelcomeScreenTestTags.bigHeader)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.big_title_welcome))
        }
    }
}