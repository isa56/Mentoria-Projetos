package com.isa56.aprendendoapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var btnDog: ImageButton
    private lateinit var btnCat: ImageButton
    private lateinit var imgView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCat = findViewById(R.id.cat)
        btnDog = findViewById(R.id.dog)
        imgView = findViewById(R.id.imageView)

        btnDog.setOnClickListener {
            dogFunction()
        }

        btnCat.setOnClickListener {
            catFunction()
        }
    }

    private fun dogFunction(){
        val retrofitDog = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dogService: DogService = retrofitDog.create(DogService::class.java)
        val callDog = dogService.randomDog().enqueue(object : Callback<Dog> {
            override fun onResponse(call: Call<Dog>, response: Response<Dog>) {
                val randomDog = response.body()!!

                Log.i("dogMessage", randomDog.message)
                Log.i("dogStatus", randomDog.status)

                Picasso.get()
                    .load(randomDog.message)
                    .into(imgView)
            }

            override fun onFailure(call: Call<Dog>, t: Throwable) {
                Log.i("dogError", t.toString())
            }})
    }

    private fun catFunction(){
        val retrofitCat = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val catService: CatService = retrofitCat.create(CatService::class.java)
        val callCat = catService.randomCat().enqueue(object:Callback<Cat>{
            override fun onResponse(call: Call<Cat>, response: Response<Cat>) {
                val randomCat = response.body()!!

                Log.i("catMessage", randomCat.url)

                Picasso.get()
                    .load(randomCat.url)
                    .into(imgView)
            }

            override fun onFailure(call: Call<Cat>, t: Throwable) {
                Log.i("catError", t.toString())
            }})
    }

}