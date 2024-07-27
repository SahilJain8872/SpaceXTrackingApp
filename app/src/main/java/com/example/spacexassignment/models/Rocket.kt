package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rocket (
    @SerializedName("rocket_id") var rocketId: String?,
    @SerializedName("rocket_name") var rocketName: String?,
    @SerializedName("rocket_type") var rocketType: String?,
    @SerializedName("first_stage") var firstStage: FirstStage?,
    @SerializedName("second_stage") var secondStage: SecondStage?,
    @SerializedName("fairings") var fairings: Fairings?
): Parcelable

