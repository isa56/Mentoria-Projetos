package com.meteoro.githubusersexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/users/{username}")
    fun getUser(@Path("username") username: String): Call<User>
}
