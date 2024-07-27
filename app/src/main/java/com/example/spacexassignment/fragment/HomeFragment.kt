package com.example.spacexassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexassignment.LaunchDetailActivity
import com.example.spacexassignment.adapter.MissionAdapter
import com.example.spacexassignment.databinding.FragmentHomeBinding
import com.example.spacexassignment.viewmodels.LaunchMissionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var missionAdapter: MissionAdapter
    private val viewModel: LaunchMissionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView

        missionAdapter = MissionAdapter{ mission->
            startActivity(LaunchDetailActivity.newInstance(requireContext(), mission))
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = missionAdapter

        lifecycleScope.launch {
            viewModel.missionData.collect { launches ->
                if(launches.isNotEmpty())
                    missionAdapter.submitList(launches)
            }
        }
    }
}