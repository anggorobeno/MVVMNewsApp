package com.androiddevs.mvvmnewsapp.data.remote.network

import com.androiddevs.mvvmnewsapp.data.remote.response.ArticlesResponse
import com.androiddevs.mvvmnewsapp.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/top-headlines")
    suspend fun getArticles(
        @Query("country") countryCode : String = "id",
        @Query("apiKey") apiKey : String = Constant.API_KEY,
        @Query("page") page : Int = 1
    ): Response<ArticlesResponse>
    @GET("/v2/everything")
    suspend fun searchArticle(
        @Query("country") countryCode : String = "id",
        @Query("q") searchQuery : String,
        @Query("apiKey") apiKey : String = Constant.API_KEY,
        @Query("page") page : Int = 1
    ): Response<ArticlesResponse>
}