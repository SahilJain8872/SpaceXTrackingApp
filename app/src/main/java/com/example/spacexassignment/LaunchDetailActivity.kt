package com.example.spacexassignment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.spacexassignment.databinding.ActivityLaunchBinding
import com.example.spacexassignment.models.MissionData
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LaunchDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchBinding

    companion object{
        const val MISSION_DATA = "mission_data"
        fun newInstance(context: Context, missionData: MissionData) =
            Intent(context, LaunchDetailActivity::class.java).apply {
                putExtra(MISSION_DATA, missionData)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()

    }

    private fun setupUI(){
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "SpaceXTracking"

    }
}