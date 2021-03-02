package com.companyname.challengeapp.data.repository

import com.companyname.challengeapp.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RemoteDataSourceTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private var repository = Repository(FakeRemoteDataSource())

    @Test
    fun repository_cinemaworlddata_notnull() {
        runBlocking {
            assert(repository.getCinemaWorldData() !=null)
        }
    }
}