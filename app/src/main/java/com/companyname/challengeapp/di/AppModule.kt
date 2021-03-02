package com.companyname.challengeapp.di

import com.companyname.challengeapp.data.remote.BaseDataSource
import com.companyname.challengeapp.data.remote.DataService
import com.companyname.challengeapp.data.remote.HeaderInterceptor
import com.companyname.challengeapp.data.remote.RemoteDataSource
import com.companyname.challengeapp.data.repository.Repository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HeaderInterceptor): OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://challenge.lexicondigital.com.au/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): DataService = retrofit.create(DataService::class.java)

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BaseDataSourceRemote

    @Singleton
    @BaseDataSourceRemote
    @Provides
    fun provideRemoteDataSource(dataService: DataService) = RemoteDataSource(dataService)

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource) =
        Repository(remoteDataSource)
}