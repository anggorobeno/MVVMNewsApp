package com.androiddevs.mvvmnewsapp.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.data.local.entity.ArticleEntity

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleEntity: ArticleEntity) : Long

    @Query("SELECT * FROM article_table")
    fun getAllArticles() : LiveData<List<ArticleEntity>>

    @Delete
    suspend fun deletArticle(articleEntity: ArticleEntity)

}