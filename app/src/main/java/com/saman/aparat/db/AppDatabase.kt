package com.saman.aparat.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saman.aparat.models.Video

@Database(
    entities = [Video::class],
    version = 1,
    exportSchema = false
)


abstract class AppDatabase() : RoomDatabase() {


    abstract fun idao():IDAO

    companion object {

        var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {

                    instance = Room.databaseBuilder(context,
                        AppDatabase::class.java,"myDb.db")
                        .allowMainThreadQueries().build()

            }
            return instance!!
        }
    }

}




