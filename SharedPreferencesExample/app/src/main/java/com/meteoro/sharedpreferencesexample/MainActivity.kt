package com.meteoro.sharedpreferencesexample

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var edtValor: EditText
    private lateinit var btnSave: Button
    private lateinit var txtValor: TextView

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("valor_salvo", Context.MODE_PRIVATE)

        edtValor = findViewById(R.id.edt_valor)
        btnSave = findViewById(R.id.btn_save)
        txtValor = findViewById(R.id.tv_valor)

        btnSave.setOnClickListener {
            val valor = edtValor.text.toString()
            if (valor.isNotEmpty()) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("campo_app", valor)
                editor.putInt("campo_inteiro", 10)
                editor.apply()

                txtValor.text = valor
            }
        }

        val valorString = sharedPreferences.getString("campo_app", "")
        val valorInteiro = sharedPreferences.getInt("campo_inteiro", -5)
        txtValor.text = "$valorString - $valorInteiro"
    }
}
