package com.example.booksearchapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.booksearchapp.R
import com.example.booksearchapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /* MainActivity에 Viewbinding 추가*/
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

//    private val Context.dataStore by preferencesDataStore(DATASTORE_NAME)
//    private val workManager = WorkManager.getInstance(application)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

//        setUpBottomNavigationView()
//        if (savedInstanceState == null) {
//            binding.bottomNavigationView.selectedItemId = R.id.fragment_search
//        }
        setupJetpackNavigation()

//        val database = BookSearchDatabase.getInstance(this)
//
//        /*get datastore*/
//        val bookSearchRepository = BookSearchRepositoryImpl(database, dataStore)
//
//        val factory = BookSearchViewModelProviderFactory(bookSearchRepository, workManager, this)

        /* ViewModel을 Activity위에 띄우기 위해 이 과정을 거치는 것.*/
//        bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]
    }

    private fun setupJetpackNavigation() {
        val host =
            supportFragmentManager.findFragmentById(R.id.booksearch_nav_host_fragment) as NavHostFragment?
                ?: return
        navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)


        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment_search,
                R.id.fragment_favorite,
                R.id.fragment_setting
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
//    private fun setUpBottomNavigationView() {
//        binding.bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.fragment_search -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, SearchFragment())
//                        .commit()
//                    true
//                }
//
//                R.id.fragment_favorite -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FavoriteFragment())
//                        .commit()
//                    true
//                }
//
//                R.id.fragment_setting -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, SettingFragment())
//                        .commit()
//                    true
//                }
//
//                else -> false
//            }
//        }
//    }

}
