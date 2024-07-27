package com.example.spacexassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexassignment.LaunchDetailActivity
import com.example.spacexassignment.adapter.MissionAdapter
import com.example.spacexassignment.databinding.FragmentSearchBinding
import com.example.spacexassignment.viewmodels.LaunchMissionViewModel

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var missionAdapter: MissionAdapter
    private val viewModel: LaunchMissionViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        setupUi()
        return binding.root
    }

    private fun setupUi(){
        recyclerView = binding.recyclerView
        viewModel.fetchSpaceLaunches()
        missionAdapter = MissionAdapter{ mission->
            startActivity(LaunchDetailActivity.newInstance(requireContext(), mission))
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = missionAdapter
        binding.viewSearch.apply {
            setOnClickListener {
                if (isIconified) {
                    isIconified = false
                }
            }
            setOnQueryTextFocusChangeListener { _, hasFocus ->
                binding.tvHintText.visibility = if (hasFocus) View.GONE else View.VISIBLE
            }
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let{
                        val launches = viewModel.getMissionListByQuery(it.lowercase())
                        if(launches.isNotEmpty())
                            missionAdapter.submitList(launches)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
    }
}