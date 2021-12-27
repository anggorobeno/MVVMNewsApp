package com.androiddevs.mvvmnewsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.data.NewsRepository
import com.androiddevs.mvvmnewsapp.data.local.entity.ArticleEntity
import com.androiddevs.mvvmnewsapp.utils.Constant
import kotlinx.coroutines.launch

class BreakingNewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    val _articleLiveData = MutableLiveData<List<ArticleEntity>>()

    fun getArticleLiveData() : LiveData<List<ArticleEntity>>{
        return _articleLiveData
    }

    init {
        getArticle("id", Constant.API_KEY,1)
    }

    fun getArticle(
        countryCode: String,
        apiKey: String,
        page: Int
    ){
        viewModelScope.launch {
            val result = newsRepository.getArticles(countryCode, apiKey, page)
            _articleLiveData.value = result
        }
    }
}