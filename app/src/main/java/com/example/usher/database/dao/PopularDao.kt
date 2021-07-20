package com.example.usher.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.usher.database.ResultData
import com.example.usher.models.get_popular_movie.Result

@Dao
interface PopularDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(popular: ResultData)

    @Query("SELECT * FROM popular_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<ResultData>>
}