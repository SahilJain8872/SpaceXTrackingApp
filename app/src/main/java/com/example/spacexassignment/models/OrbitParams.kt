package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrbitParams (
    @SerializedName("reference_system") var referenceSystem: String?,
    @SerializedName("regime") var regime: String?,
    @SerializedName("longitude") var longitude: String?,
    @SerializedName("semi_major_axis_km") var semiMajorAxisKm: String?,
    @SerializedName("eccentricity") var eccentricity: String?,
    @SerializedName("periapsis_km") var periapsisKm: String?,
    @SerializedName("apoapsis_km") var apoapsisKm: String?,
    @SerializedName("inclination_deg") var inclinationDeg: String?,
    @SerializedName("period_min") var periodMin: String?,
    @SerializedName("lifespan_years") var lifespanYears: String?,
    @SerializedName("epoch") var epoch: String?,
    @SerializedName("mean_motion") var meanMotion: String?,
    @SerializedName("raan") var raan: String?,
    @SerializedName("arg_of_pericenter") var argOfPericenter: String?,
    @SerializedName("mean_anomaly") var meanAnomaly: String?
): Parcelable
