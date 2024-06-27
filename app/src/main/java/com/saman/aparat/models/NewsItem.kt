package com.saman.aparat.models

import com.google.gson.annotations.SerializedName

data class NewsItem(

    @SerializedName("icon")
    var icon: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("link")
    var link: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("type")
    var type: String
)