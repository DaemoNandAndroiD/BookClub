package com.example.bookclub

import android.content.res.Resources
import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import com.example.bookclub.screens.welcome_screen.WelcomeScreen
import com.example.bookclub.screens.welcome_screen.WelcomeScreenTestTags
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

class WelcomeScreenTest : DefaultTest() {

    @Test
    fun testInteraction(){
        composeTestRule.setContent {
            WelcomeScreen {  }
        }

        with(composeTestRule){
            onNodeWithTag(testTag = WelcomeScreenTestTags.smallHeader)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.small_title_welcome))

            onNodeWithTag(testTag = WelcomeScreenTestTags.bigHeader)
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.big_title_welcome))

            onNodeWithTag(testTag = WelcomeScreenTestTags.enterBtn)
                .assertIsDisplayed()
                .assertIsNotEnabled()

            onNodeWithTag(testTag = WelcomeScreenTestTags.enterBtnText, useUnmergedTree = true)
                .assertTextEquals(resources.getString(R.string.enter_button_title))

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
        }
    }
}