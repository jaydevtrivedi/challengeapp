package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.data.entities.BaseJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DataService {
    @GET("/api/{filter}/movies")
    suspend fun getData(@Path("filter") filter: String) : Response<BaseJson>

    @GET("/api/{filter}/movie/{ID}")
    suspend fun getMovie(@Path("filter") filter: String, @Path("filter") id: String) : Response<BaseJson>
}