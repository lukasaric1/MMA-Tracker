package com.example.mma_application

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Show splash screen for 2 seconds
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Close the SplashScreen activity
        }, 3000)
    }
}
