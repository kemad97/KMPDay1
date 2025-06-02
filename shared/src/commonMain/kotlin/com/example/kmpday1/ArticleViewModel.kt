package com.example.kmpday1

import kotlinx.coroutines.flow.StateFlow

expect class ArticleViewModel {
    fun loadArticles()
    val uiState: StateFlow<ArticleUIState>
}