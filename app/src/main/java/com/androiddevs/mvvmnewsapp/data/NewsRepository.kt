package com.androiddevs.mvvmnewsapp.data

import com.androiddevs.mvvmnewsapp.data.local.entity.ArticleEntity
import com.androiddevs.mvvmnewsapp.data.remote.RemoteDataSource

class NewsRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getArticles(
        countryCode: String,
        apiKey: String,
        page: Int
    ): List<ArticleEntity> {
        val articleResponse = remoteDataSource.getArticles(countryCode, apiKey, page)
        val articleList = ArrayList<ArticleEntity>()
        with(articleResponse?.articles) {
            this?.map {
                val article = ArticleEntity(
                    0,
                    it.publishedAt,
                    it.author,
                    it.urlToImage,
                    it.description,
                    it.source,
                    it.title,
                    it.url,
                    it.content,
                )
                articleList.add(article)
            }
        }
        return articleList
    }

}