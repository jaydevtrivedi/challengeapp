package com.companyname.challengeapp.data.repository

import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.remote.RemoteDataSource
import com.companyname.challengeapp.data.remote.RealData
import com.companyname.challengeapp.utils.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FakeRemoteDataSource : RemoteDataSource() {

    override
    suspend fun getCinemaWorldData() : Resource {
        var gson = Gson()
        val baseJson = object : TypeToken<BaseJson?>() {}.type
        val data: BaseJson = gson.fromJson(RealData.realcinemaworld, baseJson)
        return Resource.success(data)
    }

    override
    suspend fun getFilmWorldData() : Resource {
        var gson = Gson()
        val baseJson = object : TypeToken<BaseJson?>() {}.type
        val data: BaseJson = gson.fromJson(RealData.realfilmworld, baseJson)
        return Resource.success(data)
    }
}