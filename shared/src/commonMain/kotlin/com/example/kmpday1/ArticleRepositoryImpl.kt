package com.example.kmpday1

class ArticleRepositoryImpl(
    private val articlesService: ArticlesService
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return articlesService.fetchArticles().mapNotNull { raw ->
            raw.title?.let { title ->
                Article(
                    title = title,
                    content = raw.description ?: "",
                    date = raw.publishedAt ?: "",
                    imageUrl = raw.urlToImage ?: ""
                )
            }
        }
    }
}