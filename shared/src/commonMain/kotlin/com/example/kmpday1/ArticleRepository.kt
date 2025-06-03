package com.example.kmpday1

interface ArticleRepository {
    suspend fun getArticles(): List<Article>

}