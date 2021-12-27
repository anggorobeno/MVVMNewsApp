package com.androiddevs.mvvmnewsapp.data.remote

import com.androiddevs.mvvmnewsapp.data.remote.network.ApiHelper
import com.androiddevs.mvvmnewsapp.data.remote.network.ApiService
import com.androiddevs.mvvmnewsapp.data.remote.response.ArticlesResponse
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService)  {
     suspend fun getArticles(
        countryCode: String,
        apiKey: String,
        page: Int
    ): ArticlesResponse? {
        return apiService.getArticles(countryCode, apiKey, page).body()
    }

     suspend fun searchArticle(
        countryCode: String,
        searchQuery: String,
        apiKey: String,
        page: Int
    ): ArticlesResponse? {
        return apiService.searchArticle(countryCode, searchQuery, apiKey, page).body()
    }
}