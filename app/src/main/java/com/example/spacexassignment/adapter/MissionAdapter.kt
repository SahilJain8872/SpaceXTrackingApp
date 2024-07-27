package com.example.spacexassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexassignment.R
import com.example.spacexassignment.databinding.ItemLaunchMissionBinding
import com.example.spacexassignment.models.MissionData

class MissionAdapter(private val missionsList: List<MissionData>,
                     private val onItemClick: (MissionData) -> Unit) : RecyclerView.Adapter<MissionAdapter.MissionViewHolder>() {
    inner class MissionViewHolder(private val binding: ItemLaunchMissionBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(missionsList[position])
                }
            }
        }
        fun bind(mission: MissionData) {
            val context = itemView.context
            binding.missionName.text = context.getString(R.string.mission_name, mission.missionName)
            binding.launchYear.text = context.getString(R.string.launch_year, mission.launchYear.toString())
            binding.rocketName.text = context.getString(R.string.rocket_name, mission.rocket?.rocketName ?: "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val binding = ItemLaunchMissionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MissionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        holder.bind(missionsList[position])
    }

    override fun getItemCount(): Int = missionsList.size
}
