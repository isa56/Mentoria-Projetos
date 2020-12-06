package com.isa56.aprendendoapis.services

import com.isa56.aprendendoapis.classes.Cat
import retrofit2.Call
import retrofit2.http.GET

interface CatService{
    @GET("images/search")
    fun randomCat(): Call<List<Cat>>
    fun catRandom();
}