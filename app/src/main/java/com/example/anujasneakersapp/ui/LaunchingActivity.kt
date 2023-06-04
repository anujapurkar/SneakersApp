package com.example.anujasneakersapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.anujasneakersapp.R
import com.example.anujasneakersapp.databinding.ActivityLaunchingBinding

class LaunchingActivity : AppCompatActivity() {

    lateinit var binding: ActivityLaunchingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launchSneakerActivity()
    }

    private fun launchSneakerActivity() {
        Handler().postDelayed({
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 2000)

    }
}