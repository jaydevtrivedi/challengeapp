package com.companyname.challengeapp.di

import com.companyname.challengeapp.data.remote.BaseDataSource
import com.companyname.challengeapp.data.remote.RemoteDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BaseDataSourceRemote

    @Singleton
    @BaseDataSourceRemote
    @Provides
    fun provideBaseDataSource(): BaseDataSource = RemoteDataSource()
}