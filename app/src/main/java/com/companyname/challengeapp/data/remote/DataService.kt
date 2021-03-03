package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.entities.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DataService {
    @GET("/api/{filter}/movies")
    suspend fun getData(@Path("filter") filter: String) : Response<BaseJson>

    @GET("/api/{filter}/movie/{id}")
    suspend fun getMovie(@Path("filter") filter: String, @Path("id") id: String) : Response<Movie>
}