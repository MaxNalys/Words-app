package com.example.words_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.words_app.databinding.ActivityAntonymsBinding

class AntonymsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAntonymsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAntonymsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val antonyms = intent.getStringArrayListExtra("antonyms")
        binding.antonymsTxt.text = antonyms?.joinToString(", ") ?: "No antonyms found"
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
