package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Telemetry (
    @SerializedName("flight_club") var flightClub: String?
): Parcelable