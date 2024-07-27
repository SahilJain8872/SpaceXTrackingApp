package com.example.spacexassignment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.spacexassignment.databinding.ActivityLaunchBinding
import com.example.spacexassignment.models.MissionData
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LaunchDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchBinding
    private var missionData: MissionData? = null

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
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "SpaceXTracking"
        fetchDataFromIntent()
        setupUI()

    }

    private fun fetchDataFromIntent(){
        missionData = intent.getParcelableExtra(MISSION_DATA)
    }

    private fun setupUI(){
        binding.apply {
            tvTitle.text = getString(R.string.launch_details, "")
            tvLaunchDate.text = getString(R.string.launch_date, missionData?.launchDateLocal)
            tvMissionName.text = getString(R.string.mission_name, missionData?.missionName)
            tvRocketDetails.text = getString(R.string.rocket_name, missionData?.rocket?.rocketName)
            tvPayloadDetails.text = getString(R.string.payload_details, missionData?.rocket?.secondStage?.payloads?.get(0)?.manufacturer)
            tvLaunchSite.text = getString(R.string.launch_site, missionData?.launchSite?.siteName)
            tvLinknMedia.text = Html.fromHtml(
                getString(R.string.links_amp_media, missionData?.links?.articleLink, missionData?.links?.articleLink))
            tvLinknMedia.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}