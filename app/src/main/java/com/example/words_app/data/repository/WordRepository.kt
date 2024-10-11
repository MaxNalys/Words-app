package com.example.words_app.data.repository

import com.example.words_app.data.model.DefinitionResponse
import com.example.words_app.data.model.WordResponse
import com.example.words_app.data.remote.RetrofitInstance

class WordRepository {
    private val api = RetrofitInstance.api

    suspend fun getSynonyms(word: String): WordResponse? {
        return try {
            api.getSynonyms(word)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getAntonyms(word: String): WordResponse? {
        return try {
            api.getAntonyms(word)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getDefinitions(word: String): List<DefinitionResponse>? {
        return try {
            api.getDefinitions(word)?.definitions
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getRhymes(word: String): List<String>? {
        return try {
            api.getRhymes(word)?.rhymes?.all
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getExamples(word: String): WordResponse? {
        return try {
            api.getExamples(word)
        } catch (e: Exception) {
            null
        }
    }
}
