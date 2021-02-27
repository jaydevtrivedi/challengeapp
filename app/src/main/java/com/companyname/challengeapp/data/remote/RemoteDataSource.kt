package com.companyname.challengeapp.data.remote

import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.remote.TestData.Companion.jsonString
import com.companyname.challengeapp.utils.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import timber.log.Timber
import javax.inject.Inject

class RemoteDataSource @Inject constructor(): BaseDataSource(){
    suspend fun getData() : BaseJson {
        var gson = Gson()
        val baseJson = object : TypeToken<BaseJson?>() {}.type
        val data: BaseJson = gson.fromJson(jsonString, baseJson)
        Timber.d("jaydev " + data.Provider)
        return data
    }
}