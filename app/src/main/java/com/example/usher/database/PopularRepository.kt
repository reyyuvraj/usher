package com.example.usher.database

import androidx.lifecycle.LiveData
import com.example.usher.database.dao.PopularDao
import com.example.usher.models.get_popular_movie.Result

class PopularRepository(private val popularDao: PopularDao) {
    val readAllData : LiveData<List<ResultData>> = popularDao.readAllData()

    suspend fun addData(popular: ResultData)
    {
        popularDao.addData(popular)
    }
}