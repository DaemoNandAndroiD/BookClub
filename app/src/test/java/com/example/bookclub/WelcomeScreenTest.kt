package com.example.bookclub

import android.content.res.Resources
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import com.example.bookclub.screens.welcome_screen.WelcomeScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class WelcomeScreenTest {

    @get:Rule val composeTestRule = createComposeRule()

    private val resources:Resources
        get() = InstrumentationRegistry.getInstrumentation().context.resources

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun testInteraction(){
        composeTestRule.setContent {
            WelcomeScreen {  }
        }

        with(composeTestRule){
            onNodeWithTag(testTag = "small_header")
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.small_title_welcome))

            onNodeWithTag(testTag = "big_header")
                .assertIsDisplayed()
                .assertTextEquals(resources.getString(R.string.big_title_welcome))

            onNodeWithTag(testTag = resources.getString(R.string.test_tag_button_enter))
                .assertIsDisplayed()
                .assertIsNotEnabled()

            onNodeWithTag(testTag = resources.getString(R.string.enter_button_title))
                .assertTextEquals(resources.getString(R.string.enter_button_title))

            onNodeWithTag(testTag = "login_input_field")
                .assertIsDisplayed()
                .performClick()
                .performTextInput("login")

            onNodeWithTag(testTag = "password_input")
                .assertIsDisplayed()
                .performClick()
                .performTextInput("password")

            onNodeWithTag(testTag = resources.getString(R.string.test_tag_button_enter))
                .assertIsEnabled()
                .performClick()
        }
    }
}