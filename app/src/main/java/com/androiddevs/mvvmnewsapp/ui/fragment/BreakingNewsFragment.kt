package com.androiddevs.mvvmnewsapp.ui.fragment

import androidx.fragment.app.Fragment
import com.androiddevs.mvvmnewsapp.base.BaseFragment
import com.androiddevs.mvvmnewsapp.databinding.FragmentBreakingNewsBinding

class BreakingNewsFragment : BaseFragment<FragmentBreakingNewsBinding, BreakingNewsViewModel>() {
    override fun getViewBinding(): FragmentBreakingNewsBinding {
        return FragmentBreakingNewsBinding.inflate(layoutInflater)
    }
    override fun getViewModel(): Class<BreakingNewsViewModel> {
        return BreakingNewsViewModel::class.java
    }


}