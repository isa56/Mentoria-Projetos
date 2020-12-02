package com.meteoro.dogapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var btnRandomDog: Button
    private lateinit var imageDog: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageDog = findViewById(R.id.image_dog)
        btnRandomDog = findViewById(R.id.btn_random_dog)
        btnRandomDog.setOnClickListener {
            makeRandomHttpAccess()
        }
    }

    private fun makeRandomHttpAccess() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dogService: DogService = retrofit.create(DogService::class.java)

        val call = dogService.randomDog().enqueue(object : Callback<Dog> {
            override fun onResponse(call: Call<Dog>, response: Response<Dog>) {
                val randomDog = response.body()!!

                Log.d("MainActivity", randomDog.message)
                Log.d("MainActivity", randomDog.status)

                Toast.makeText(this@MainActivity, "${randomDog.status}", Toast.LENGTH_LONG).show()

                Picasso.get()
                    .load(randomDog.message)
                    .into(imageDog)
            }

            override fun onFailure(call: Call<Dog>, error: Throwable) {
                Log.e("MainActivity", "Deu erro -> $error")
            }
        })

        Log.d("MainActivity", "Antes do retorno")
    }
}
