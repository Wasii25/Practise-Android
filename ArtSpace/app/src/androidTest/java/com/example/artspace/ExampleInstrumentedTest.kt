import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.artspace.ArtSpaceScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtSpaceScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun artworkTitle_isDisplayed() {
        composeTestRule.setContent {
            ArtSpaceScreen()
        }

        // Assert the title of the first artwork is shown
        composeTestRule.onNodeWithText("Artwork One")
            .assertIsDisplayed()
    }
    @Test
    fun clickingNext_showsNextArtwork() {
        composeTestRule.setContent {
            ArtSpaceScreen()
        }

        // Click the Next button
        composeTestRule.onNodeWithText("Next")
            .performClick()

        // Verify the second artwork title is displayed
        composeTestRule.onNodeWithText("Artwork Two")
            .assertIsDisplayed()
    }

}

