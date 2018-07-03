package com.example.fylmr.beertracker.activities

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import com.example.fylmr.beertracker.R
import com.example.fylmr.beertracker.models.FirebaseModel
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@LargeTest
class LoginActivityTest {

    @Rule
    @JvmField
    val activityRule =
            ActivityTestRule(LoginActivity::class.java)

    val firebaseModel = Mockito.mock(FirebaseModel::class.java)

    @Test
    fun areInvisibleViewsInvisibleTest() {
        onView(withId(R.id.loading_pb)).check(matches(
                not(isDisplayed())
        ))
        onView(withId(R.id.error_tv)).check(matches(
                not(isDisplayed())
        ))
    }

}