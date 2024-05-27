package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etConfirmPassword: EditText = findViewById(R.id.etConfirmPassword)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val tvMessage: TextView = findViewById(R.id.tvMessage)

        val pesel = "12345678901" // Przykładowy numer PESEL
        tvMessage.text = "Autor: $pesel"

        btnSubmit.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            when {
                !isValidEmail(email) -> tvMessage.text = "Nieprawidłowy adres e-mail"
                password != confirmPassword -> tvMessage.text = "Hasła się różnią"
                else -> tvMessage.text = "Witaj $email"
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
