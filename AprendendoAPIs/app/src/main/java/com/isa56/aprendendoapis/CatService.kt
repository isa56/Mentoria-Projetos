package com.isa56.aprendendoapis

import retrofit2.Call
import retrofit2.http.GET

interface CatService{
    @GET("images/search")
    fun randomCat(): Call<Cat>

}