package com.example.retrofitwithroomandmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithroomandmvvm.ApiService.Apiservice
import com.example.retrofitwithroomandmvvm.ApiService.RetrofitHelper
import com.example.retrofitwithroomandmvvm.Repository.Repositorys
import com.example.retrofitwithroomandmvvm.Repository.Response
import com.example.retrofitwithroomandmvvm.ViewModel.MainviewModel
import com.example.retrofitwithroomandmvvm.ViewModel.MainviewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainviewModel: MainviewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repositorys = (application as MainApplication).repositorys

        mainviewModel = ViewModelProvider(this,MainviewModelFactory(repositorys)).get(MainviewModel::class.java)

        mainviewModel.quotes.observe(this, Observer {
            when(it){
                is Response.Loading->{}
                is Response.Success->{
                   it.data?.let {
                       Log.d("success hereer",it.results.size.toString())
                   }
                }
                is Response.Error->{
                    it.errorMessage
                    Toast.makeText(this, it.errorMessage.toString(),Toast.LENGTH_SHORT).show()
                }
            }

        })

    }
}