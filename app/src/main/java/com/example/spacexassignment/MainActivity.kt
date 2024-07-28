package com.example.spacexassignment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.spacexassignment.databinding.ActivityMainBinding
import com.example.spacexassignment.fragment.HomeFragment
import com.example.spacexassignment.fragment.SearchFragment
import com.example.spacexassignment.fragment.StoreFragment
import com.example.spacexassignment.viewmodels.LaunchMissionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: LaunchMissionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            viewModel.setCurrentTabPosition(R.id.navigation_home)
        }
        setupUI()
    }

    private fun setupUI(){
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "SpaceXTracking"
         viewModel.getCurrentTabPosition().observe(this){ menuItemId->
             when (menuItemId) {
                 R.id.navigation_home -> {
                     replaceFragment(HomeFragment(), "HomeFragmentTag")
                 }
                 R.id.navigation_store -> {
                     replaceFragment(StoreFragment(), "StoreFragmentTag")
                 }
                 R.id.navigation_search -> {
                     replaceFragment(SearchFragment(), "SearchFragmentTag")
                 }
             }
         }

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            viewModel.setCurrentTabPosition(menuItem.itemId)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, tag: String){
        val addedFragment = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.navHostFragment.id, addedFragment ?: fragment, tag)
        }
    }
}