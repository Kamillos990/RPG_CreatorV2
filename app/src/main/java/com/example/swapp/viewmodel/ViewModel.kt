package com.example.swapp.viewmodel

import android.graphics.Paint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapp.model.*
import com.example.swapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ViewModel @Inject constructor(val repository: Repository):ViewModel() {
    val myClassesResponse:MutableLiveData<Response<Classes>> = MutableLiveData()
    val myRacesResponse:MutableLiveData<Response<Races>> = MutableLiveData()
    val myAlignmentsResponse:MutableLiveData<Response<Alignments>> = MutableLiveData()


    fun getClasses(){
        viewModelScope.launch {
            val response: Response<Classes> = repository.getClasses()
            myClassesResponse.value=response
        }
    }

    fun getRaces(){
        viewModelScope.launch {
            val response: Response<Races> = repository.getRaces()
            myRacesResponse.value=response
        }
    }

    fun getAlignments(){
        viewModelScope.launch {
            val response: Response<Alignments> = repository.getAlignments()
            myAlignmentsResponse.value=response
        }
    }
}