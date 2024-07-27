package com.example.spacexassignment.di

import com.example.spacexassignment.network.NetworkService
import com.example.spacexassignment.repository.LaunchMissionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideLaunchMissionRepository(netService: NetworkService): LaunchMissionRepository {
        return LaunchMissionRepository(netService)
    }
}