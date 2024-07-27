package com.example.spacexassignment.models
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fairings(
    @SerializedName("reused") var reused: Boolean?,
    @SerializedName("recovery_attempt") var recoveryAttempt: Boolean?,
    @SerializedName("recovered") var recovered: Boolean?,
    @SerializedName("ship") var ship: String?
): Parcelable
