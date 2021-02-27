package com.companyname.challengeapp.data.repository

import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.remote.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(val remoteDataSource: RemoteDataSource) {
    suspend fun getData() : BaseJson {
        return remoteDataSource.getData()
    }
}