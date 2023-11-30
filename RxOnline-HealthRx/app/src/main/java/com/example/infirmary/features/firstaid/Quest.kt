package com.example.infirmary.features.firstaid

data class Quest(
    val id: Int,
    val text: String,
    val choices: List<String>,
    val followUpQuestions: Map<String, Quest>? = null
)
