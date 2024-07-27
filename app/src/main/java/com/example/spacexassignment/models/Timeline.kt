package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Timeline (
    @SerializedName("webcast_liftoff" ) var webcastLiftoff : Int?
): Parcelable
