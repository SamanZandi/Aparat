package com.saman.aparat.db;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.saman.aparat.models.Video;


@androidx.room.Database( entities = {Video.class},version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {


   // private Database(){}  //singleton

    public static Database instance=null;

    public abstract IDAO idao();
    public static Database getInstance(Context context){

        if(instance==null){
            instance= Room.databaseBuilder( context,Database.class,"Aparat")
                    .allowMainThreadQueries().build();
        }

        return instance;
    }
}
