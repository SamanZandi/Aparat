package com.saman.aparat.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.saman.aparat.models.Video

@Dao
interface IDAO {

    @Insert
   fun insert(video: Video?): Long

    @Insert
    fun insertHistory(video: Video?): Long

    @Update
  fun update(video: Video?)

    @Query("Select * from tbl_video")
    fun getVideoList(): List<Video>

    @Query("Select * from tbl_video")
    fun getHistoryList(): List<Video>

    @Query("delete from tbl_video where id=:id ")
   fun Delete(id: Int)

    @Query("SELECT EXISTS (SELECT * FROM tbl_video WHERE id=:id  )")
     fun isRowIsExist(id: Int): Boolean
}