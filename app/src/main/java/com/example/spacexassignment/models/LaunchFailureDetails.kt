package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchFailureDetails(
    @SerializedName("time") var time: Int?,
    @SerializedName("altitude") var altitude: String?,
    @SerializedName("reason") var reason: String?
): Parcelable
