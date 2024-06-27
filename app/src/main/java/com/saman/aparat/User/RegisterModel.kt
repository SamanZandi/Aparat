package com.saman.aparat.User

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterModel (
    @SerializedName("user")
    @Expose
    var user: User,
    @SerializedName("code")
    @Expose
    var code: Data
)