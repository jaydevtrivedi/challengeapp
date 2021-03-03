package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.utils.Resource
import javax.inject.Inject

open class RemoteDataSource @Inject constructor(
    private val dataService: DataService
) : BaseDataSource() {

    override
    suspend fun getData(filter: String): Resource =
        getMovieList { dataService.getData(filter) }

    override
    suspend fun getMovieData(filter: String, id: String): Resource =
        getMovie { dataService.getMovie(filter, id) }
}