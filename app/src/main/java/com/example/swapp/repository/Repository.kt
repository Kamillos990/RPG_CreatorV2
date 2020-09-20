package com.example.swapp.repository

import com.example.swapp.api.RetrofitInstance
import com.example.swapp.model.People
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor() {
    suspend fun getPeople(): Response<People> {
        return RetrofitInstance.api.getPeople()
    }
}