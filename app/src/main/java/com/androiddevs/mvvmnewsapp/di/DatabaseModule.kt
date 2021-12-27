package com.androiddevs.mvvmnewsapp.di

import android.content.Context
import androidx.room.Room
import com.androiddevs.mvvmnewsapp.data.local.room.NewsDB
import com.androiddevs.mvvmnewsapp.data.local.room.NewsDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }

}

private fun provideDatabase(context: Context): NewsDB {
    return Room.databaseBuilder(
        context,
        NewsDB::class.java, "news_db"
    ).fallbackToDestructiveMigration().build()
}

private fun provideDao(db: NewsDB) :NewsDao {
    return db.getNewsDao()
}