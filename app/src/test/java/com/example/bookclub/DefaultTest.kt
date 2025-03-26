package com.example.bookclub

import android.content.res.Resources
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"], sdk = [34])
open class DefaultTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    protected val resources: Resources
        get() = InstrumentationRegistry.getInstrumentation().context.resources
}