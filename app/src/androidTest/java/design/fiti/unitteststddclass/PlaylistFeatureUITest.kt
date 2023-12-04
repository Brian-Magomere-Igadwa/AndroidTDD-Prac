package design.fiti.unitteststddclass

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onSiblings
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToNode
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.ar.core.Config
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import design.fiti.unitteststddclass.presentation.screen.Home.HomeScreen
import design.fiti.unitteststddclass.presentation.screen.Home.HomeViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.mock
import javax.inject.Inject

//@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class PlaylistFeatureUITest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    @Mock
    lateinit var viewModel: HomeViewModel


    @get: Rule
    val composeTestRule = createComposeRule()

    @Before
    fun init() {
        hiltRule.inject()
        viewModel = HomeViewModel()
    }

    @Before
    fun setUpHomeScreen() {
        composeTestRule.setContent {
            HomeScreen()
        }
    }

    @Test
    fun homescreen_showsGroovyTopBar() {
        composeTestRule.onNodeWithText("Groovy").assertExists("Groovy wasn't found on your UI")
    }

    @Test
    fun homeViewModel_fetchesPlaylists() {
        viewModel.fetchPlaylists()
        assertEquals(10, viewModel.uiState.value.size)
    }

    @Test
    fun homescreen_displaysListOfPlaylists() {
        composeTestRule.onNodeWithTag("playlist_lazy_column")
            .performScrollToNode(hasTestTag("playlist_lazy_column9")).onChildren()
            .assertCountEquals(10)
    }
}