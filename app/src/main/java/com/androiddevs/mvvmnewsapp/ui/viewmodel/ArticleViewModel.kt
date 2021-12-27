package com.androiddevs.mvvmnewsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.androiddevs.mvvmnewsapp.data.NewsRepository

class ArticleViewModel(private val newsRepository: NewsRepository) : ViewModel() {
}