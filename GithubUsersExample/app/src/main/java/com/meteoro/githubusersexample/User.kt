package com.meteoro.githubusersexample

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("avatar_url") val avatar: String,
    @SerializedName("name") val name: String
)
