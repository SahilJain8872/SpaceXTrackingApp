package com.example.spacexassignment.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_missions")
data class FavouriteMissionEntity(
    @PrimaryKey
    val flightNumber: Int
)
