package com.companyname.challengeapp.utils

import com.companyname.challengeapp.data.entities.BaseJson


data class Resource(val status: Status, val data: BaseJson?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun success(data: BaseJson?): Resource {
            return Resource(Status.SUCCESS, data, null)
        }

        fun error(message: String, data: BaseJson? = null): Resource {
            return Resource(Status.ERROR, data, message)
        }

        fun loading(data: BaseJson? = null): Resource {
            return Resource(Status.LOADING, data, null)
        }
    }
}