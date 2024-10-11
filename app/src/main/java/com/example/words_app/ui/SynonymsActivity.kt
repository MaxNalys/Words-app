package com.example.words_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.words_app.databinding.ActivitySynonymsBinding

class SynonymsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySynonymsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySynonymsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val synonyms = intent.getStringArrayListExtra("synonyms")
        binding.synonymsTxt.text = synonyms?.joinToString(", ") ?: "No synonyms found"
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
