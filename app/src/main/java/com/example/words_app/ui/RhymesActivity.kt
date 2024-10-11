package com.example.words_app.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.words_app.databinding.ActivityRhymesBinding

class RhymesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRhymesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRhymesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val synonyms = intent.getStringArrayListExtra("rhymes")
        Log.d("RhymesActivity", "Rhymes: rhymes") // Логування

        binding.rhymesTxt.text = synonyms?.joinToString(", ") ?: "No rhymes found"
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}