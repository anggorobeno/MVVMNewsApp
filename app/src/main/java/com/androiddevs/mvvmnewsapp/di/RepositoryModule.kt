package com.androiddevs.mvvmnewsapp.di

import com.androiddevs.mvvmnewsapp.data.NewsRepository
import org.koin.dsl.module

val repoModule = module {
    single { NewsRepository(get()) }
}