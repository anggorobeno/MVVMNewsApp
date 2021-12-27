package com.androiddevs.mvvmnewsapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.data.local.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class], version = 1, exportSchema = false
)
@TypeConverters(Converter::class)
abstract class NewsDB : RoomDatabase(){
    abstract fun getNewsDao() : NewsDao
}