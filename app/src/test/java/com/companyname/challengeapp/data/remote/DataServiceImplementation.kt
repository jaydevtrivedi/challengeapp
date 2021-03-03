package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.data.TestData
import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.entities.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response

class DataServiceImplementation : DataService {

    override suspend fun getData(filter: String): Response<BaseJson> {
        var gson = Gson()
        val baseJson = object : TypeToken<BaseJson?>() {}.type
        return Response.success(
            if (filter == "cinemaworld")
                gson.fromJson(TestData.cinemaworld, baseJson)
            else
                gson.fromJson(TestData.filmworld, baseJson)
        )
    }

    override suspend fun getMovie(filter: String, id: String): Response<Movie> {
        var gson = Gson()
        val baseJson = object : TypeToken<Movie?>() {}.type
        return Response.success(
            gson.fromJson(TestData.movie, baseJson)
        )
    }
}