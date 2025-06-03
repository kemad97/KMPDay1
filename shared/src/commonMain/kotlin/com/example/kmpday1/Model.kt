package com.example.kmpday1
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    val title: String?,
    val description: String?,
    val publishedAt: String?,
    val urlToImage: String?
)

@Serializable
data class ArticlesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleRaw>?
)