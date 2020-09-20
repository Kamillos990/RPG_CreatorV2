package com.example.swapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapp.model.People
import com.example.swapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ViewModel @Inject constructor(val repository: Repository):ViewModel() {
    val myPeopleResponse:MutableLiveData<Response<People>> = MutableLiveData()

    fun getPeople(){
        viewModelScope.launch {
            val response: Response<People> = repository.getPeople()
            myPeopleResponse.value=response
        }
    }
}