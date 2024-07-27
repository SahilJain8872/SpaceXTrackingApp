package com.example.spacexassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.spacexassignment.databinding.ActivityMainBinding
import com.example.spacexassignment.fragment.HomeFragment
import com.example.spacexassignment.fragment.SearchFragment
import com.example.spacexassignment.fragment.StoreFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()

    }

    private fun setupUI(){
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "SpaceXTracking"
        replaceFragment(HomeFragment())

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    HomeFragment()
                }
                R.id.navigation_store -> {
                    StoreFragment()
                }
                R.id.navigation_search -> {
                    SearchFragment()
                }
                else -> {null}
            }?.let {fragment->
                replaceFragment(fragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.navHostFragment.id, fragment)
        }
    }
}