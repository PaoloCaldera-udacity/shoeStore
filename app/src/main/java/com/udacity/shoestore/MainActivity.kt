package com.udacity.shoestore

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        Timber.plant(Timber.DebugTree())
    }
}
