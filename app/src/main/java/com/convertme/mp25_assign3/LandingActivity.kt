package com.convertme.mp25_assign3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val user = intent.getParcelableExtra<User>("USER_DATA")
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        user?.let {
            tvWelcome.text = "Welcome, ${it.name}!"
        }

        btnLogout.setOnClickListener {
            finish()
        }
    }
}