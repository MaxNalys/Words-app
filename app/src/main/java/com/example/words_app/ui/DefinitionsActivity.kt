package com.example.words_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.words_app.databinding.ActivityAntonymsBinding
import com.example.words_app.databinding.ActivityDefinitionsBinding

class DefinitionsActivity:AppCompatActivity() {
    private lateinit var binding: ActivityDefinitionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDefinitionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val antonyms = intent.getStringArrayListExtra("definitions")
        binding.definitionsTxt.text = antonyms?.joinToString(", ") ?: "No definitions found"
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}