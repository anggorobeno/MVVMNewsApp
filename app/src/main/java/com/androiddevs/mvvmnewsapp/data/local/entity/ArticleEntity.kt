package com.androiddevs.mvvmnewsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androiddevs.mvvmnewsapp.data.remote.response.Source
import com.google.gson.annotations.SerializedName

@Entity(tableName = "article_table")
data class ArticleEntity(
    @PrimaryKey
    val id: Int? = null,

    val publishedAt: String? = null,

    val author: String? = null,

    val urlToImage: String? = null,

    val description: String? = null,

    val source: Source? = null,

    val title: String? = null,

    val url: String? = null,

    val content: String? = null
)
