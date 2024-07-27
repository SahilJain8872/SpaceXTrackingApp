package com.example.spacexassignment.models
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FirstStage(
    @SerializedName("cores") var cores: ArrayList<Cores>
): Parcelable
