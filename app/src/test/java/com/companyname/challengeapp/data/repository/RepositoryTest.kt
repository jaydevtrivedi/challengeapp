package com.companyname.challengeapp.data.repository

import com.companyname.challengeapp.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RemoteDataSourceTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private var repository = Repository(FakeRemoteDataSource())

    @Test
    fun cinemaworlddata_datanotempty() {
        runBlocking {
            val resource = repository.getCinemaWorldData()
            assert(resource.data != null)
            assert(resource.data!!.Provider.isNotEmpty())
            assert(resource.data!!.Movies.isNotEmpty())
            assert(resource.data!!.Movies.size == 11)
        }
    }

    @Test
    fun filmworlddata_datanotempty() {
        runBlocking {
            val resource = repository.getFilmWorldData()
            assert(resource.data != null)
            assert(resource.data!!.Provider.isNotEmpty())
            assert(resource.data!!.Movies.isNotEmpty())
            assert(resource.data!!.Movies.size == 11)
        }
    }

    @Test
    fun moviedata_datanotnullempty() {
        runBlocking {
            val resource = repository.getMovieData("cinemaworld", "cw0080684")
            assert(resource.movie != null)
            assert(!resource.movie!!.ID.isNullOrEmpty())
            assert(!resource.movie!!.Title.isNullOrEmpty())
            assert(!resource.movie!!.Rated.isNullOrEmpty())
            assert(!resource.movie!!.Released.isNullOrEmpty())
            assert(!resource.movie!!.Runtime.isNullOrEmpty())
            assert(!resource.movie!!.Genre.isNullOrEmpty())
            assert(!resource.movie!!.Director.isNullOrEmpty())
            assert(!resource.movie!!.Writer.isNullOrEmpty())
            assert(!resource.movie!!.Actors.isNullOrEmpty())
            assert(!resource.movie!!.Plot.isNullOrEmpty())
            assert(!resource.movie!!.Language.isNullOrEmpty())
            assert(!resource.movie!!.Country.isNullOrEmpty())
            assert(!resource.movie!!.Poster.isNullOrEmpty())
            assert(!resource.movie!!.Type.isNullOrEmpty())
            assert(!resource.movie!!.Production.isNullOrEmpty())
            assert(resource.movie!!.Price > 0 && resource.movie!!.Price < 50)
            assert(resource.movie!!.Year > 1700 && resource.movie!!.Year < 2022)
        }
    }
}