package com.companyname.challengeapp.ui.PrimaryScreen

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.companyname.challengeapp.R
import com.companyname.challengeapp.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
class PrimaryScreenTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun recyclerview_isdisplayed_has11items() {
        val activityScenario = launch(MainActivity::class.java)
        Thread.sleep(4000) // provide time to load data from the internet
        activityScenario.onActivity { activity ->
            // Disable animations in RecyclerView
            (activity.findViewById(R.id.movies_recycler_view) as RecyclerView).itemAnimator = null
            assert((activity.findViewById(R.id.movies_recycler_view) as RecyclerView).adapter!!.itemCount == 11)
        }

        onView(allOf(withId(R.id.theatre_company_name)))
            .perform(click())
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.description)))
            .perform(click())
            .check(matches(isDisplayed()))
        onView(withId(R.id.movies_recycler_view)).check(matches(ViewMatchers.isDisplayed()))
    }
}