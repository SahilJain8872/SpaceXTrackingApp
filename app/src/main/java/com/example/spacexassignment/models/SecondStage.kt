package com.example.spacexassignment.models
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SecondStage (
    @SerializedName("block") var block: Int?,
    @SerializedName("payloads") var payloads: ArrayList<Payloads>?
): Parcelable