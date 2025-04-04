package com.aditya.codingtestandroid.model

import retrofit2.http.GET

interface ApiService {

    @GET("/matt%2025:31-33,46")
    suspend fun getDqta() : BibleResponse

}