package com.silaeva.coursefinder.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.silaeva.coursefinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}