package com.saman.aparat.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize


@Entity(tableName = "tbl_video")

@Parcelize
 class Video(

 @PrimaryKey(autoGenerate = true)
 var videoId: Int = 0,

 @SerializedName("cat_id")
 @Expose
 @ColumnInfo(name = "cat_id")
 var catId: String,



 @SerializedName("creator")
 @Expose
 @ColumnInfo(name = "creator")
 var creator: String,

 @SerializedName("description")
 @Expose
 @ColumnInfo(name = "description")
 var description: String,


 @SerializedName("icon")
 @Expose
 @ColumnInfo(name = "icon")
 var icon: String,

 @SerializedName("id")
 @Expose
 @ColumnInfo(name = "id")
 var id: String,

 @SerializedName("link")
 @Expose
 @ColumnInfo(name = "link")
 var link: String,

 @SerializedName("special")
 @Expose
 @ColumnInfo(name = "special")
 var special: String,

 @SerializedName("time")
 @Expose
 @ColumnInfo(name = "time")
 var time: String,

 @SerializedName("title")
 @Expose
 @ColumnInfo(name = "title")
 var title: String,

 @SerializedName("view")
 @Expose
 @ColumnInfo(name = "view")
var view: String ,

): Parcelable

