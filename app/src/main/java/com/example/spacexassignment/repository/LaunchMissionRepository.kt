package com.example.spacexassignment.repository

import com.example.spacexassignment.models.MissionData
import com.example.spacexassignment.network.NetworkService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LaunchMissionRepository@Inject constructor(
    private val networkService: NetworkService
) {
    fun getLaunchMissionData(): Flow<List<MissionData>> {
        return networkService.getLaunchMissionData()
    }
}