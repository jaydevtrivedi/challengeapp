package com.companyname.challengeapp.data.repository

import com.companyname.challengeapp.data.remote.BaseDataSource
import com.companyname.challengeapp.data.remote.RemoteDataSource
import com.companyname.challengeapp.di.AppModule
import com.companyname.challengeapp.utils.Resource
import javax.inject.Inject

class Repository @Inject constructor(@AppModule.BaseDataSourceRemote val remoteDataSource: BaseDataSource) {

    suspend fun getData(filter: String): Resource {
        return (remoteDataSource as RemoteDataSource).getData(filter)
    }

    suspend fun getMovieData(filter: String, id: String): Resource {
        return (remoteDataSource as RemoteDataSource).getMovieData(filter, id)
    }
}