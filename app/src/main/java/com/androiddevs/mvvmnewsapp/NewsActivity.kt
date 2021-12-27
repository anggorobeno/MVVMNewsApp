package com.androiddevs.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.databinding.ActivityNewsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {
    private var _binding: ActivityNewsBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        // hide action bar
        supportActionBar?.hide()
        val navController = findNavController(R.id.newsNavHostFragment)
        val navView : BottomNavigationView? =  binding?.bottomNavigationView
        navView?.setupWithNavController(navController)
//        navView?.setOnItemSelectedListener { item ->
//            if (item.itemId == navView.selectedItemId) {
//                NavigationUI.onNavDestinationSelected(item, navController)
//            }
//            true
//        }

    }
}
