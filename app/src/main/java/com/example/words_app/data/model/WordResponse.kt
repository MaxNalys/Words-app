package com.example.words_app.data.model

data class WordResponse(
    val word: String,
    val synonyms: List<String>? = null,
    val antonyms: List<String>? = null,
    val definitions: List<DefinitionResponse>? = null,
    val rhymes: RhymesResponse? = null,
    val examples: List<String>? = null
)

data class RhymesResponse(
    val all: List<String>?
)

data class DefinitionResponse(
    val definition: String,
    val partOfSpeech: String
)
