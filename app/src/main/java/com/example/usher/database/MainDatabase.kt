package com.example.usher.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.usher.database.dao.PopularDao
import com.example.usher.models.get_popular_movie.Result
import com.example.usher.util.Converters


@Database(entities = [ResultData::class], version = 1 )
@TypeConverters(Converters::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun PopularDao(): PopularDao

    companion object{
        @Volatile
        private var INSTANCE: MainDatabase? =null

        fun getDatabase(context: Context) : MainDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!= null)
                return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase ::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                return  instance

            }
        }
    }

}