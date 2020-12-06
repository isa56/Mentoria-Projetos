package com.isa56.aprendendoapis.services

import com.isa56.aprendendoapis.classes.Dog
import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random")
    fun randomDog(): Call<Dog>

}