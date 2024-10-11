package com.example.words_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.words_app.databinding.ActivityExamplesBinding

class ExamplesActivity :AppCompatActivity(){
    private lateinit var binding: ActivityExamplesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExamplesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val antonyms = intent.getStringArrayListExtra("examples")
        binding.examplesTxt.text = antonyms?.joinToString(", ") ?: "No examples found"
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}