package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput


@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun test_drivers_screen_functionality() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        //add a driver and verify display
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        //clear drivers and verify driver is removed
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        //test back button returns to HomeScreen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }}