package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.remote.RealData.Companion.realcinemaworld
import com.companyname.challengeapp.data.remote.RealData.Companion.realfilmworld
import com.companyname.challengeapp.utils.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class RemoteDataSource : BaseDataSource(){

    override
    suspend fun getCinemaWorldData() : Resource {
        var gson = Gson()
        val baseJson = object : TypeToken<BaseJson?>() {}.type
        val data: BaseJson = gson.fromJson(realcinemaworld, baseJson)
        return Resource.success(data)
    }

    override
    suspend fun getFilmWorldData() : Resource {
        var gson = Gson()
        val baseJson = object : TypeToken<BaseJson?>() {}.type
        val data: BaseJson = gson.fromJson(realfilmworld, baseJson)
        return Resource.success(data)
    }
}