package com.example.spacexassignment.network

import com.example.spacexassignment.models.MissionData
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface NetworkService {
    @GET("launches")
    fun getLaunchMissionData(): Flow<List<MissionData>>
}