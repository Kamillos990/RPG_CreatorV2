package com.example.swapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swapp.viewmodel.ViewModel
import com.example.swapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
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
        viewModel.getClasses()
        viewModel.myClassesResponse.observe(this, Observer { response ->
            response.let {
                val classArray = arrayListOf<String>()

                response.body()!!.results.forEach(){
                    classArray.add(it.name)
                }

                val spinner_classes = findViewById<Spinner>(R.id.spinner_classes)
                if (spinner_classes != null) {
                    val adapter_classes = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item, classArray)

                    spinner_classes.adapter = adapter_classes
                }
            }
        })

        viewModel.getRaces()
        viewModel.myRacesResponse.observe(this, Observer { response ->
            response.let {
                val racesArray = arrayListOf<String>()

                response.body()!!.results.forEach(){
                    racesArray.add(it.name)
            }
                val spinner_races = findViewById<Spinner>(R.id.spinner_races)
                if (spinner_races != null) {
                    val adapter_races = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item, racesArray)

                    spinner_races.adapter = adapter_races
                }
        }

    })


        viewModel.getAlignments()
        viewModel.myAlignmentsResponse.observe(this, Observer { response ->
            response.let {
                val racesArray = arrayListOf<String>()

                response.body()!!.results.forEach(){
                    racesArray.add(it.name)
                }
                val spinner_alignments = findViewById<Spinner>(R.id.spinner_alignments)
                if (spinner_alignments != null) {
                    val adapter_alignments= ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item, racesArray)

                    spinner_alignments.adapter = adapter_alignments
                }
            }

        })
  }
}

