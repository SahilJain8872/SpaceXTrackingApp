package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cores(
    @SerializedName("core_serial") var coreSerial: String?,
    @SerializedName("flight") var flight: Int?,
    @SerializedName("block") var block: String?,
    @SerializedName("gridfins") var gridfins: Boolean?,
    @SerializedName("legs") var legs: Boolean?,
    @SerializedName("reused") var reused: Boolean?,
    @SerializedName("land_success") var landSuccess: String?,
    @SerializedName("landing_intent") var landingIntent: Boolean?,
    @SerializedName("landing_type") var landingType: String?,
    @SerializedName("landing_vehicle") var landingVehicle: String?
): Parcelable
