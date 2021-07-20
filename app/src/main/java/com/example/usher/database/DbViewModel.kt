package com.example.usher.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DbViewModel(application: Application): AndroidViewModel(application) {
    val readAllData : LiveData<List<ResultData>>
    private val repository : PopularRepository

    init {
        val popularDao = MainDatabase.getDatabase(application).PopularDao()
        repository = PopularRepository(popularDao)
        readAllData = repository.readAllData
    }

    fun addData(popular: ResultData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addData(popular)
        }
    }
}