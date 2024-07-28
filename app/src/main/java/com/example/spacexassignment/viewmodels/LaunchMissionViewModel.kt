package com.example.spacexassignment.viewmodels

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexassignment.models.MissionData
import com.example.spacexassignment.repository.FavouriteMissionRepository
import com.example.spacexassignment.repository.LaunchMissionRepository
import com.example.spacexassignment.room.FavouriteMissionEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.http.Query
import javax.inject.Inject

@HiltViewModel
class LaunchMissionViewModel @Inject constructor(
    private val launchRepository: LaunchMissionRepository,
    private val favMissionRepository: FavouriteMissionRepository
) : ViewModel() {
    private val _missionData = MutableStateFlow<List<MissionData>>(emptyList())
    val missionData: StateFlow<List<MissionData>> get() = _missionData
    private val _favoriteMissions = MutableStateFlow<List<FavouriteMissionEntity>>(emptyList())
    val favoriteMissions: StateFlow<List<FavouriteMissionEntity>> = _favoriteMissions
    var webViewStateRetain = Bundle()
    private var currentTabPosition = MutableLiveData<Int>()
    var url = "https://www.spacex.com/vehicles/falcon-9/"

    init {
        viewModelScope.launch {
            favMissionRepository.getAllFavoriteMissions().collect { missions ->
                _favoriteMissions.value = missions
            }
        }
    }
    fun fetchSpaceLaunches() {
        viewModelScope.launch {
            launchRepository.getLaunchMissionData()
                .flowOn(Dispatchers.IO)
                .catch { error ->
                    Log.e("LaunchMissionViewModel",error.message.toString())
                }
                .collect { launches ->
                    _missionData.value = launches
                }
        }
    }

    fun getMissionListByQuery(query: String): List<MissionData> {
        val result = arrayListOf<MissionData>()
        _missionData.value.forEach { mission ->
            val missionName = mission.missionName?.lowercase()?.contains(query) ?: false
            val launchYear = mission.launchYear?.contains(query) ?: false
            val rocketName = mission.rocket?.rocketName?.lowercase()?.contains(query) ?: false

            if (missionName || launchYear || rocketName)
                result.add(mission)
        }
        return result
    }
    fun setWebViewState(bundle: Bundle) {
        webViewStateRetain = bundle
    }

    fun setCurrentTabPosition(tabPosition: Int){
        currentTabPosition.value = tabPosition
    }

    fun getCurrentTabPosition() = currentTabPosition

}
