package com.example.kmpday1

import kotlinx.coroutines.flow.StateFlow

expect class ArticleViewModel(repository: ArticleRepository) {
    fun loadArticles()
    val uiState: StateFlow<ArticleUIState>
}