package com.example.swapp.viewmodel

import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val mainviewmodelprovider:Provider<ViewModel>):ViewModelProvider.Factory{

    override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {
        return mainviewmodelprovider.get() as T
    }


}