package com.androiddevs.mvvmnewsapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding, VM : ViewModel> : Fragment() {
    private var _binding : T? = null
    private val binding get() = _binding
    private lateinit var viewModel: VM
    private var root: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        init()
        root = binding?.root
        return root
    }

    private fun init() {
        _binding = getViewBinding()
        viewModel = ViewModelProvider(this).get(getViewModel())

    }

    protected abstract fun getViewBinding(): T
    abstract fun getViewModel(): Class<VM>

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        root = null

    }
}