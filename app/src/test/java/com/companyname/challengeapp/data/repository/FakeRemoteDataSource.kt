package com.companyname.challengeapp.data.repository

import com.companyname.challengeapp.data.TestData
import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.entities.Movie
import com.companyname.challengeapp.data.remote.RemoteDataSource
import com.companyname.challengeapp.utils.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.mockk.mockk

class FakeRemoteDataSource : RemoteDataSource(mockk()) {
    override
    suspend fun getData(filter: String): Resource {
        var gson = Gson()
        val baseJson = object : TypeToken<BaseJson?>() {}.type

        var data: BaseJson = if (filter == "cinemaworld")
            gson.fromJson(TestData.cinemaworld, baseJson)
        else
            gson.fromJson(TestData.filmworld, baseJson)

        return Resource.success(data)
    }

    override
    suspend fun getMovieData(filter: String, id: String): Resource {
        var gson = Gson()
        val movie = object : TypeToken<Movie?>() {}.type
        val data: Movie = gson.fromJson(TestData.movie, movie)
        return Resource.success(data)
    }
}