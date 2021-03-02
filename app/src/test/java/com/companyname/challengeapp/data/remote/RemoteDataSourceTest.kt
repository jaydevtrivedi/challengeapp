package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.CoroutineTestRule
import com.companyname.challengeapp.data.repository.FakeRemoteDataSource
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RemoteDataSourceTest{

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private var remoteDataSource: RemoteDataSource = RemoteDataSource(DataServiceImplementation())

    @Test
    fun cinemaworlddata_isnotnull() {
        runBlocking {
            assert(remoteDataSource.getCinemaWorldData() !=null)
        }
    }

    @Test
    fun filmworlddata_isnotnull() {
        runBlocking {
            assert(remoteDataSource.getFilmWorldData() !=null)
        }
    }

    @Test
    fun cinemaworlddata_datanotempty() {
        runBlocking {
            val resource = remoteDataSource.getCinemaWorldData()
            assert(resource.data!=null)
            assert(resource.data!!.Provider.isNotEmpty())
        }
    }

    @Test
    fun filmworlddata_datanotempty() {
        runBlocking {
            val resource = remoteDataSource.getFilmWorldData()
            assert(resource.data!=null)
            assert(resource.data!!.Provider.isNotEmpty())
        }
    }

}