package com.meteoro.dogapi

import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random")
    fun randomDog(): Call<Dog>
}
