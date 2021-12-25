package com.androiddevs.mvvmnewsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.androiddevs.mvvmnewsapp.databinding.FragmentArticleBinding
import com.androiddevs.mvvmnewsapp.databinding.FragmentSearchNewsBinding

class SearchNewsFragment : Fragment() {
    private lateinit var viewModel: ViewModel
    private var _binding: FragmentSearchNewsBinding? = null
    private val binding get() = _binding
    private var root: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchNewsBinding.inflate(inflater, container, false)
        root = binding?.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        root = null
    }
}