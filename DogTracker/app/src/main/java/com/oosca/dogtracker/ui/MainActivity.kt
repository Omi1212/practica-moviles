package com.oosca.dogtracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oosca.dogtracker.R
import com.oosca.dogtracker.databinding.ActivityMainBinding
import com.oosca.dogtracker.databinding.FragmentDogBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}