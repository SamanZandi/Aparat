package com.saman.aparat.User

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("user")
    var user: User,
    @SerializedName("code")
    var code: Data
)
