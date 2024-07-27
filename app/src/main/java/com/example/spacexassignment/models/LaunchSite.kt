package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchSite (
    @SerializedName("site_id") var siteId: String?,
    @SerializedName("site_name") var siteName: String?,
    @SerializedName("site_name_long") var siteNameLong: String?
): Parcelable
