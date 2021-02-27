package com.companyname.challengeapp.data.entities

import com.companyname.challengeapp.data.entities.Movies

data class BaseJson (
    val Provider : String,
    val Movies : List<Movies>
)