package com.companyname.challengeapp.data.remote

import okhttp3.logging.HttpLoggingInterceptor

fun getLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BASIC
    return interceptor
}
