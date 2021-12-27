package com.androiddevs.mvvmnewsapp.data.remote.network

import com.androiddevs.mvvmnewsapp.data.remote.response.ArticlesResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getArticles(countryCode: String,apiKey:String,page: Int) : Response<ArticlesResponse>
    suspend fun searchArticle(countryCode: String,searchQuery: String,apiKey:String,page: Int) : Response<ArticlesResponse>
}