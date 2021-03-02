package com.companyname.challengeapp.data.remote

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val newRequest: Request

        newRequest = request.newBuilder()
            .addHeader("x-api-key", "Yr2636E6BTD3UCdleMkf7UEdqKnd9n361TQL9An7")
            .build()
        return chain.proceed(newRequest)
    }
}