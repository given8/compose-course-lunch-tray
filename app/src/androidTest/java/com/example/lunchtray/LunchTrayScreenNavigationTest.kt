package com.example.lunchtray

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LunchTrayScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController
    @Before
    fun createLunchTrayNavHost(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            LunchTrayApp(navController = navController)
        }
    }

    @Test
    fun lunchTrayNavHost_verifyStartScreen(){
        navController.assertCurrentRouteName(LunchTrayScreen.Start.name)
    }

    @Test
    fun navHost_clickStartOrder_NavigateToEntreeScreen(){
        composeTestRule.onNodeWithTag(START_BUTTON_TAG).performClick()
        navController.assertCurrentRouteName(LunchTrayScreen.Entree.name)
    }
}