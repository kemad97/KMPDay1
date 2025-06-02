package com.example.kmpday1

import kotlinx.coroutines.flow.StateFlow

actual class ArticleViewModel {
    actual fun loadArticles() {
    }

    actual val uiState: StateFlow<ArticleUIState>
        get() = TODO("Not yet implemented")
}