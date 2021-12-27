package com.androiddevs.mvvmnewsapp.di

import com.androiddevs.mvvmnewsapp.ui.viewmodel.ArticleViewModel
import com.androiddevs.mvvmnewsapp.ui.viewmodel.BreakingNewsViewModel
import com.androiddevs.mvvmnewsapp.ui.viewmodel.SavedNewsViewModel
import com.androiddevs.mvvmnewsapp.ui.viewmodel.SearchNewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ ArticleViewModel(get()) }
    viewModel{ BreakingNewsViewModel(get()) }
    viewModel{ SearchNewsViewModel(get()) }
    viewModel{ SavedNewsViewModel(get()) }
}