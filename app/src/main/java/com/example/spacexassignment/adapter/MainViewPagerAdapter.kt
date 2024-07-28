package com.example.spacexassignment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.spacexassignment.fragment.HomeFragment
import com.example.spacexassignment.fragment.SearchFragment
import com.example.spacexassignment.fragment.StoreFragment

class MainViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragmentList = listOf(
        HomeFragment(),
        StoreFragment(),
        SearchFragment()
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}