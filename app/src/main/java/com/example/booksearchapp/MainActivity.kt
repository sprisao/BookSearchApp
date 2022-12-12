package com.example.booksearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.booksearchapp.data.repository.BookSearchRepositoryImpl
import com.example.booksearchapp.databinding.ActivityMainBinding
import com.example.booksearchapp.ui.view.FavoriteFragment
import com.example.booksearchapp.ui.view.SearchFragment
import com.example.booksearchapp.ui.view.SettingFragment
import com.example.booksearchapp.ui.viewmodel.BookSearchViewModel
import com.example.booksearchapp.ui.viewmodel.BookSearchViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    /* MainActivity에 Viewbinding 추가*/
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var bookSearchViewModel: BookSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setUpBottomNavigationView()
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.fragment_search
        }

        val bookSearchRepository = BookSearchRepositoryImpl()
        val factory = BookSearchViewModelProviderFactory(bookSearchRepository, this)
        bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]
    }

    private fun setUpBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.fragment_search -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, SearchFragment())
                        .commit()
                    true
                }

                R.id.fragment_favorite -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FavoriteFragment())
                        .commit()
                    true
                }

                R.id.fragment_setting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, SettingFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}
