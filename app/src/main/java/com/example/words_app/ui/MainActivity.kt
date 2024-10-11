package com.example.words_app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.words_app.data.repository.WordRepository
import com.example.words_app.viewmodel.WordViewModelFactory
import com.example.words_app.databinding.ActivityMainBinding
import com.example.words_app.viewmodel.WordViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = WordRepository()
        val factory = WordViewModelFactory(repository)
        wordViewModel = ViewModelProvider(this, factory).get(WordViewModel::class.java)

        binding.synonymsBtn.setOnClickListener {
            val word = binding.inputWord.text.toString()
            wordViewModel.fetchSynonyms(word)
            wordViewModel.synonyms.observe(this) { synonyms ->
                val intent = Intent(this, SynonymsActivity::class.java)
                intent.putStringArrayListExtra("synonyms", ArrayList(synonyms))
                startActivity(intent)
            }
        }
        binding.antonymsBtn.setOnClickListener {
            val word = binding.inputWord.text.toString()
            wordViewModel.fetchAntonyms(word)
            wordViewModel.antonyms.observe(this) { antonyms ->
                val intent = Intent(this, AntonymsActivity::class.java)
                intent.putStringArrayListExtra("antonyms", ArrayList(antonyms))
                startActivity(intent)
            }
        }
        binding.definitionsBtn.setOnClickListener {
            val word = binding.inputWord.text.toString()
            wordViewModel.fetchDefinitions(word)
            wordViewModel.definitions.observe(this) { definitions ->
                // Отримуємо список рядків визначень
                val definitionTexts = definitions?.map { it.definition } ?: emptyList()

                val intent = Intent(this, DefinitionsActivity::class.java)
                intent.putStringArrayListExtra("definitions", ArrayList(definitionTexts))
                startActivity(intent)
            }
        }

        binding.rhymesBtn.setOnClickListener {
            val word = binding.inputWord.text.toString()
            wordViewModel.fetchRhymes(word)
            wordViewModel.rhymes.observe(this) { rhymes ->
                val intent = Intent(this, RhymesActivity::class.java)
                intent.putStringArrayListExtra("rhymes", ArrayList(rhymes))
                startActivity(intent)
            }
        }
        binding.examplesBtn.setOnClickListener {
            val word = binding.inputWord.text.toString()
            wordViewModel.fetchExamples(word)
            wordViewModel.examples.observe(this) { examples ->
                val intent = Intent(this, ExamplesActivity::class.java)
                intent.putStringArrayListExtra("examples", ArrayList(examples))
                startActivity(intent)
            }
        }




    }
}
