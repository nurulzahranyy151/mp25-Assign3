package com.convertme.mp25_assign3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class RegistrationActivity : AppCompatActivity() {

    private lateinit var tilName: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var tilConfirmPassword: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        tilName = findViewById(R.id.tilName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = tilName.editText?.text.toString()
            val email = tilEmail.editText?.text.toString()
            val password = tilPassword.editText?.text.toString()
            val confirmPassword = tilConfirmPassword.editText?.text.toString()

            if (validateInput(name, email, password, confirmPassword)) {
                val user = User(name, email, password)
                navigateToLanding(user)
            }
        }
    }

    private fun validateInput(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        tilName.error = null
        tilEmail.error = null
        tilPassword.error = null
        tilConfirmPassword.error = null

        return when {
            name.isEmpty() -> {
                tilName.error = "Name cannot be empty"
                false
            }
            email.isEmpty() -> {
                tilEmail.error = "Email cannot be empty"
                false
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                tilEmail.error = "Invalid email format"
                false
            }
            password.isEmpty() -> {
                tilPassword.error = "Password cannot be empty"
                false
            }
            password.length < 6 -> {
                tilPassword.error = "Password must be at least 6 characters"
                false
            }
            password != confirmPassword -> {
                tilConfirmPassword.error = "Passwords don't match"
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
        finish()
    }
}