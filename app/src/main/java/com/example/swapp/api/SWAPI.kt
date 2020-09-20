package com.example.swapp.api

import com.example.swapp.model.People
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface SWAPI {

    @GET("people")
    suspend fun getPeople(): Response<People>
}