package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Payloads (
    @SerializedName("payload_id") var payloadId: String?,
    @SerializedName("norad_id") var noradId: ArrayList<String>?,
    @SerializedName("reused") var reused: Boolean?,
    @SerializedName("customers") var customers: ArrayList<String>?,
    @SerializedName("nationality") var nationality: String?,
    @SerializedName("manufacturer") var manufacturer: String?,
    @SerializedName("payload_type") var payloadType: String?,
    @SerializedName("payload_mass_kg") var payloadMassKg: Int?,
    @SerializedName("payload_mass_lbs") var payloadMassLbs: Int?,
    @SerializedName("orbit") var orbit: String?,
    @SerializedName("orbit_params") var orbitParams: OrbitParams?
): Parcelable

