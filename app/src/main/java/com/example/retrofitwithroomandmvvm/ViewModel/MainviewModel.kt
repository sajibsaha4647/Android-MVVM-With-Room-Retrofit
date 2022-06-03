package com.example.retrofitwithroomandmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithroomandmvvm.Model.Quotelist
import com.example.retrofitwithroomandmvvm.Repository.Repositorys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainviewModel(private val repositorys: Repositorys):ViewModel() {


    init {
        viewModelScope.launch (Dispatchers.IO){
            repositorys.getQuotes(1)
        }
    }

    val quotes : LiveData<Quotelist> = repositorys.Quotes


}