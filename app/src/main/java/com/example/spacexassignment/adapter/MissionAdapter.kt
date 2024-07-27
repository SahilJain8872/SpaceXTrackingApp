package com.example.spacexassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexassignment.R
import com.example.spacexassignment.databinding.ItemLaunchMissionBinding
import com.example.spacexassignment.models.MissionData

class MissionAdapter(private val onItemClick: (MissionData) -> Unit
) : RecyclerView.Adapter<MissionAdapter.MissionViewHolder>() {

    private var missionsList: List<MissionData>? = null

    fun submitList(list: List<MissionData>?){
        missionsList = list
        notifyDataSetChanged()
    }
    inner class MissionViewHolder(private val binding: ItemLaunchMissionBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    missionsList?.get(position)?.let{
                        onItemClick(it)
                    }
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
        missionsList?.get(position)?.let{
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = missionsList?.size ?: 0
}
