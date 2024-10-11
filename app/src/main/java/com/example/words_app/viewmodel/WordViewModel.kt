package com.example.words_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.words_app.data.model.DefinitionResponse
import com.example.words_app.data.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    val synonyms = MutableLiveData<List<String>?>()
    val antonyms = MutableLiveData<List<String>?>()
    val definitions = MutableLiveData<List<DefinitionResponse>?>() // Залишаємо як список визначень
    val rhymes = MutableLiveData<List<String>?>() // Залишаємо як список рим
    val examples = MutableLiveData<List<String>?>()

    fun fetchSynonyms(word: String) {
        viewModelScope.launch {
            val response = repository.getSynonyms(word)
            synonyms.value = response?.synonyms ?: emptyList()
        }
    }

    fun fetchAntonyms(word: String) {
        viewModelScope.launch {
            val response = repository.getAntonyms(word)
            antonyms.value = response?.antonyms ?: emptyList()
        }
    }

    fun fetchDefinitions(word: String) {
        viewModelScope.launch {
            val response = repository.getDefinitions(word)
            definitions.value = response // Отримуємо список визначень
        }
    }

    fun fetchRhymes(word: String) {
        viewModelScope.launch {
            val response = repository.getRhymes(word)
            rhymes.value = response // Отримуємо список рим
        }
    }

    fun fetchExamples(word: String) {
        viewModelScope.launch {
            val response = repository.getExamples(word)
            examples.value = response?.examples ?: emptyList()
        }
    }
}
