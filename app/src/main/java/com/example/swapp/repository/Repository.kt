package com.example.swapp.repository

import com.example.swapp.api.RetrofitInstance
import com.example.swapp.model.*
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor() {
    suspend fun getClasses(): Response<Classes> {
        return RetrofitInstance.api.getClasses()
    }

    suspend fun getRaces(): Response<Races> {
        return RetrofitInstance.api.getRaces()
    }

    suspend fun getAlignments(): Response<Alignments>{
        return RetrofitInstance.api.getAlignments()
    }
}