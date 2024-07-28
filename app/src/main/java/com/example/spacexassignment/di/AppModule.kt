package com.example.spacexassignment.di

import android.content.Context
import androidx.room.Room
import com.example.spacexassignment.network.FlowCallAdapterFactory
import com.example.spacexassignment.network.NetworkService
import com.example.spacexassignment.repository.FavouriteMissionRepository
import com.example.spacexassignment.room.AppDatabase
import com.example.spacexassignment.room.FavouriteMissionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(FlowCallAdapterFactory())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "spacex_database"
        ).build()
    }

    @Provides
    fun provideFavouriteMissionDao(database: AppDatabase): FavouriteMissionDao {
        return database.favoriteDao()
    }

    @Provides
    @Singleton
    fun provideFavouriteMissionRepository(dao: FavouriteMissionDao): FavouriteMissionRepository {
        return FavouriteMissionRepository(dao)
    }
}