package com.example.spacexassignment.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavouriteMissionEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavouriteMissionDao
}