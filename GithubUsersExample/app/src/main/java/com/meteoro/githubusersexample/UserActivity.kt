package com.meteoro.githubusersexample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserActivity : AppCompatActivity() {

    lateinit var imgAvatar: ImageView
    lateinit var txtName: TextView
    lateinit var btnFollowers: Button
    lateinit var groupUser: Group
    lateinit var progress: ProgressBar
    lateinit var txtError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        imgAvatar = findViewById(R.id.img_avatar)
        txtName = findViewById(R.id.txt_name)
        btnFollowers = findViewById(R.id.btn_followers)
        groupUser = findViewById(R.id.group_user)
        progress = findViewById(R.id.progress)
        txtError = findViewById(R.id.txt_error)

        val username = intent.getStringExtra("username")
        Log.d("UserActivity", "Username: $username")
        if (username != null) {
            getUser(username)
        }
    }

    private fun getUser(username: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val userService = retrofit.create(UserService::class.java)

        userService.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()!!
                    Log.d("UserActivity", "$user")
                    progress.visibility = View.GONE
                    groupUser.visibility = View.VISIBLE

                    txtName.text = user.name

                    Picasso.get()
                        .load(user.avatar)
                        .into(imgAvatar)

                } else {
                    Log.d("UserActivity", response.message())
                    progress.visibility = View.GONE
                    groupUser.visibility = View.GONE
                    txtError.visibility = View.VISIBLE
                    txtError.text = "Api Error: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("UserActivity", t.toString())
                progress.visibility = View.GONE
                groupUser.visibility = View.GONE
                txtError.visibility = View.VISIBLE
                txtError.text = "Erro, tente novamente mais tarde"
            }
        })
    }
}
