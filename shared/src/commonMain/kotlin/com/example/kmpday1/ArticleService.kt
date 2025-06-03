package com.example.kmpday1


import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ArticlesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "8f0706b712404d49938f4771203efa6f"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines") {
            url {
                parameters.append("country", country)
                parameters.append("category", category)
                parameters.append("apiKey", apiKey)
            }
        }.body()
        return response.articles ?: emptyList()
    }
}