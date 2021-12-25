package com.androiddevs.mvvmnewsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.androiddevs.mvvmnewsapp.databinding.FragmentArticleBinding
import com.androiddevs.mvvmnewsapp.databinding.FragmentSavedNewsBinding

class SavedNewsFragment : Fragment() {
    private lateinit var viewModel: ViewModel
    private var _binding: FragmentSavedNewsBinding? = null
    private val binding get() = _binding
    private var root: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedNewsBinding.inflate(inflater, container, false)
        root = binding?.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        root = null
    }
}