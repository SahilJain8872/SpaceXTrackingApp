package com.example.spacexassignment.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteMissionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteMission(favorite: FavouriteMissionEntity)

    @Query("DELETE FROM favorite_missions WHERE flightNumber = :flightNumber")
    suspend fun deleteFavoriteMission(flightNumber: Int)

    @Query("SELECT * FROM favorite_missions ORDER BY flightNumber ASC")
    suspend fun getAllFavoritesMission(): Flow<List<FavouriteMissionEntity>>

    @Query("SELECT COUNT(*) FROM favorite_missions WHERE flightNumber = :flightNumber")
    suspend fun isFavoriteMission(flightNumber: Int): Flow<Int>
}