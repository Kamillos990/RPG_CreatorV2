package com.example.swapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swapp.viewmodel.ViewModel
import com.example.swapp.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel:ViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerComponent.create().inject(this)

        viewModel = ViewModelProvider(this, factory).get(ViewModel::class.java)
        viewModel.getPeople()
        viewModel.myPeopleResponse.observe(this, Observer { response ->
            response.let {
                Log.d("XDD", response.body()?.results.toString())
            }
        })
    }
}
