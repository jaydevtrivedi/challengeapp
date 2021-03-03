package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.utils.MenuFilter
import com.companyname.challengeapp.utils.Resource
import javax.inject.Inject

open class RemoteDataSource @Inject constructor(
    private val dataService: DataService
) : BaseDataSource() {

    //  Todo have only one calling function
    override
    suspend fun getCinemaWorldData(): Resource = getMovieList { dataService.getData(MenuFilter.CINEMA_WORLD.value) }

    override
    suspend fun getFilmWorldData(): Resource = getMovieList { dataService.getData(MenuFilter.FILM_WORLD.value) }

    override
    suspend fun getMovieData(filter: String, id: String): Resource =
        getMovie { dataService.getMovie(filter, id) }
}