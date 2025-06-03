package com.example.kmpday1


sealed class ArticleUIState {
    data object Loading : ArticleUIState()
    data class Success(val articles: List<Article>) : ArticleUIState()
    data class Error(val message: String) : ArticleUIState()
}