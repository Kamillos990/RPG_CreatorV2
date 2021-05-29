package com.example.swapp.api

import com.example.swapp.model.*
import retrofit2.Response
import retrofit2.http.GET

interface DnDAPI {

    @GET("api/classes")
    suspend fun getClasses(): Response<Classes>

    @GET("api/races")
    suspend fun getRaces(): Response<Races>

    @GET("api/alignments")
    suspend fun getAlignments(): Response<Alignments>

}