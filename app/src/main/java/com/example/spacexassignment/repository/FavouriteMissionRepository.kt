package com.example.spacexassignment.repository

import com.example.spacexassignment.room.FavouriteMissionDao
import com.example.spacexassignment.room.FavouriteMissionEntity
import kotlinx.coroutines.flow.Flow

class FavouriteMissionRepository(private val dao: FavouriteMissionDao) {

    fun getAllFavoriteMissions(): Flow<List<FavouriteMissionEntity>> {
        return dao.getAllFavoritesMission()
    }

    fun isFavoriteMission(flightNumber: Int): Flow<Int> {
        return dao.isFavoriteMission(flightNumber)
    }

    suspend fun insertFavoriteMission(favorite: FavouriteMissionEntity) {
        dao.insertFavoriteMission(favorite)
    }

    suspend fun deleteFavoriteMission(flightNumber: Int) {
        dao.deleteFavoriteMission(flightNumber)
    }
}