package com.example.spacexassignment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.example.spacexassignment.adapter.MainViewPagerAdapter
import com.example.spacexassignment.databinding.ActivityMainBinding
import com.example.spacexassignment.fragment.HomeFragment
import com.example.spacexassignment.fragment.SearchFragment
import com.example.spacexassignment.fragment.StoreFragment
import com.example.spacexassignment.viewmodels.LaunchMissionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "SpaceXTracking"

        val adapter = MainViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            binding.viewPager.currentItem = when (menuItem.itemId) {
                R.id.navigation_home -> 0
                R.id.navigation_store -> 1
                R.id.navigation_search -> 2
                else -> 0
            }
            true
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val menuItemId = when (position) {
                    0 -> R.id.navigation_home
                    1 -> R.id.navigation_store
                    2 -> R.id.navigation_search
                    else -> R.id.navigation_home
                }
                binding.bottomNavigation.selectedItemId = menuItemId
            }
        })
    }
}
