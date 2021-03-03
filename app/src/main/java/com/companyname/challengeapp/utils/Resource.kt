package com.companyname.challengeapp.utils

import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.entities.Movie


data class Resource(val status: Status, val data: BaseJson?, val message: String?, val movie: Movie?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun success(data: BaseJson?): Resource {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun loading(data: BaseJson? = null): Resource {
            return Resource(Status.LOADING, data, null, null)
        }

        //  Overloading functions with different data ideally should be able to load
        //  any data in the basejson parent format
        fun success(data: Movie?): Resource {
            return Resource(Status.SUCCESS, null, null, data)
        }

        fun loading(data: Movie? = null): Resource {
            return Resource(Status.LOADING, null, null, data)
        }

        //  Error function is common
        fun error(message: String): Resource {
            return Resource(Status.ERROR,null, message, null)
        }
    }
}