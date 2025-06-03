package com.example.kmpday1

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

actual class ArticleViewModel : BaseViewModel() {
    private val _uiState = MutableStateFlow<ArticleUIState>(ArticleUIState.Loading)
    actual val uiState: StateFlow<ArticleUIState> = _uiState


    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    private val articlesService = ArticlesService(httpClient)

    actual fun loadArticles() {
        scope.launch {
            try {
                val articlesRaw = articlesService.fetchArticles()
                val articles = articlesRaw.mapNotNull { raw ->
                    raw.title?.let { title ->
                        Article(
                            title = title,
                            content = raw.description ?: "",
                            date = raw.publishedAt ?: "",
                            imageUrl = raw.urlToImage ?: ""
                        )
                    }
                }
                _uiState.value = ArticleUIState.Success(articles)
            } catch (e: Exception) {
                _uiState.value = ArticleUIState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        httpClient.close()
    }
}