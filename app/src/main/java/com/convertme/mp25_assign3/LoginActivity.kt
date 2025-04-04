package com.convertme.mp25_assign3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegisterNow = findViewById<TextView>(R.id.tvRegisterNow)

        btnLogin.setOnClickListener {
            val username = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (validateInput(username, email, password)) {
                val user = User(username, email, password)
                navigateToLanding(user)
            }
        }

        tvRegisterNow.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    private fun validateInput(username: String, email: String, password: String): Boolean {
        return when {
            username.isEmpty() -> {
                Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show()
                false
            }
            email.isEmpty() -> {
                Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show()
                false
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun navigateToLanding(user: User) {
        val intent = Intent(this, LandingActivity::class.java).apply {
            putExtra("USER_DATA", user)
        }
        startActivity(intent)
    }
}
