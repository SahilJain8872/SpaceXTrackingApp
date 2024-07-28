package com.example.spacexassignment.repository

import com.example.spacexassignment.room.FavouriteMissionDao
import com.example.spacexassignment.room.FavouriteMissionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouriteMissionRepository(private val dao: FavouriteMissionDao) {

    suspend fun getAllFavoriteMissions(): Flow<List<FavouriteMissionEntity>> {
        return dao.getAllFavoritesMission()
    }

    suspend fun isFavoriteMission(flightNumber: Int): Flow<Boolean> {
        return dao.isFavoriteMission(flightNumber).map { count -> count > 0 }
    }

    suspend fun insertFavoriteMission(favorite: FavouriteMissionEntity) {
        dao.insertFavoriteMission(favorite)
    }

    suspend fun deleteFavoriteMission(flightNumber: Int) {
        dao.deleteFavoriteMission(flightNumber)
    }
}