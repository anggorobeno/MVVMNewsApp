package com.androiddevs.mvvmnewsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.base.BaseFragment
import com.androiddevs.mvvmnewsapp.databinding.FragmentArticleBinding
import com.androiddevs.mvvmnewsapp.databinding.FragmentBreakingNewsBinding
import com.androiddevs.mvvmnewsapp.ui.adapter.NewsAdapter
import com.androiddevs.mvvmnewsapp.ui.viewmodel.BreakingNewsViewModel
import com.androiddevs.mvvmnewsapp.utils.Constant

class BreakingNewsFragment : Fragment() {
    private val viewModel: BreakingNewsViewModel by viewModel()
    private var _binding: FragmentBreakingNewsBinding? = null
    private val adapter = NewsAdapter()
    private val binding get() = _binding
    private var root: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)
        root = binding?.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArticle()

    }

    private fun showRv() {
        with(binding?.rvBreakingNews){
            this?.layoutManager = LinearLayoutManager(context)
            this?.setHasFixedSize(true)
            this?.adapter = adapter



        }
    }

    private fun getArticle() {
        viewModel.getArticleLiveData().observe(viewLifecycleOwner,{ listArticle ->
            if (listArticle!=null){
                adapter.setNewsAdapter(listArticle)
                showRv()
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        root = null
    }


}