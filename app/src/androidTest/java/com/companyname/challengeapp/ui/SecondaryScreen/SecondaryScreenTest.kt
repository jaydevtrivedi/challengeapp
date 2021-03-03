package com.companyname.challengeapp.ui.SecondaryScreen

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import com.companyname.challengeapp.R
import com.companyname.challengeapp.launchFragmentInHiltContainer
import com.companyname.challengeapp.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
class SecondaryScreenTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun movie_isdisplayedcinemaworld() {
        //  When certain data is passed
        val bundle = Bundle()
        bundle.putString("id", "cw2488496")
        launchFragmentInHiltContainer<SecondaryScreen>(bundle, R.style.AppTheme)
        Thread.sleep(5000)  //  Wait for data to load

        //  Then data should match
        Espresso.onView(withId(R.id.movie_name))
            .check(ViewAssertions.matches(withText("Star Wars: Episode VII - The Force Awakens")))

        Espresso.onView(withId(R.id.providername))
            .check(ViewAssertions.matches(withText("cinemaworld")))

        Espresso.onView(withId(R.id.movieprice))
            .check(ViewAssertions.matches(withText("24.7")))
    }


    @Test
    fun movie_isdisplayedfilmworld() {
        //  When certain data is passed
        val bundle = Bundle()
        bundle.putString("id", "fw2488496")
        launchFragmentInHiltContainer<SecondaryScreen>(bundle, R.style.AppTheme)
        Thread.sleep(5000)  //  Wait for data to load

        //  Then data should match
        Espresso.onView(withId(R.id.movie_name))
            .check(ViewAssertions.matches(withText("Star Wars: Episode VII - The Force Awakens")))

        Espresso.onView(withId(R.id.providername))
            .check(ViewAssertions.matches(withText("filmworld")))

        Espresso.onView(withId(R.id.movieprice))
            .check(ViewAssertions.matches(withText("25.0")))
    }

    @Test
    fun check_nullid() {
        //  When certain data is passed
        val bundle = Bundle()
        bundle.putString("id", null)
        launchFragmentInHiltContainer<SecondaryScreen>(bundle, R.style.AppTheme)
        Thread.sleep(5000)  //  Wait for data to load

        //  Then data should match
        Espresso.onView(withId(R.id.movie_name))
            .check(ViewAssertions.matches(withText("Something went wrong! Please contact support.")))
    }
}