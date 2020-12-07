package com.meteoro.githubusersexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button
    lateinit var inputUsername: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar = findViewById(R.id.btn_username)
        inputUsername = findViewById(R.id.text_input_username)

        btnEntrar.setOnClickListener {
            val username = inputUsername.text.toString()
            Log.d("MainActivity", "Username: $username")
            if (username.isEmpty()) {
                // Notifica usuario
                Snackbar.make(
                    inputUsername,
                    "Campo username não pode ser vazio",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                // Vai pra tela do username
                val intent = Intent(this, UserActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            }
        }
    }
}
