package com.companyname.challengeapp.data.remote


import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.utils.Resource
import retrofit2.Response
import timber.log.Timber

abstract class BaseDataSource {

    suspend fun <T> getResult(call: suspend () -> Response<T>): Resource {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body() as BaseJson
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun error(message: String): Resource {
        Timber.d(message)
        return Resource.error("Network call has failed for a following reason: $message")
    }

    abstract suspend fun getCinemaWorldData(): Resource
    abstract suspend fun getFilmWorldData(): Resource
}