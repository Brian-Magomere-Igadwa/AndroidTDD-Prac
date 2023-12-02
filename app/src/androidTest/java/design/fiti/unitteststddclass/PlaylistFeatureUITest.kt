package design.fiti.unitteststddclass

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class PlaylistFeatureUITest {

    @get: Rule
    val composeTestRule = createComposeRule()


    @Test
    fun useAppContext() {
        composeTestRule.onNodeWithText("Groovy").assertExists("Groovy wasn't found on your UI")
    }
}