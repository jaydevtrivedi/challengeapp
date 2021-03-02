package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.utils.Resource
import javax.inject.Inject

open class RemoteDataSource @Inject constructor(
    private val dataService: DataService
) : BaseDataSource() {

    override
    suspend fun getCinemaWorldData(): Resource = getResult { dataService.getData("cinemaworld") }

    override
    suspend fun getFilmWorldData(): Resource = getResult { dataService.getData("filmworld") }
}