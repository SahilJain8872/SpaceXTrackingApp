package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MissionData(
    @SerializedName("flight_number") var flightNumber: Int?,
    @SerializedName("mission_name") var missionName: String?,
    @SerializedName("mission_id") var missionId: ArrayList<String>,
    @SerializedName("upcoming") var upcoming: Boolean?,
    @SerializedName("launch_year") var launchYear: String?,
    @SerializedName("launch_date_unix") var launchDateUnix: Int?,
    @SerializedName("launch_date_utc") var launchDateUtc: String?,
    @SerializedName("launch_date_local") var launchDateLocal: String?,
    @SerializedName("is_tentative") var isTentative: Boolean?,
    @SerializedName("tentative_max_precision") var tentativeMaxPrecision: String?,
    @SerializedName("tbd") var tbd: Boolean?,
    @SerializedName("launch_window") var launchWindow: Int?,
    @SerializedName("rocket") var rocket: Rocket?,
    @SerializedName("ships") var ships: ArrayList<String>,
    @SerializedName("telemetry") var telemetry: Telemetry?,
    @SerializedName("launch_site") var launchSite: LaunchSite?,
    @SerializedName("launch_success") var launchSuccess: Boolean?,
    @SerializedName("launch_failure_details") var launchFailureDetails: LaunchFailureDetails?,
    @SerializedName("links") var links: Links?,
    @SerializedName("details") var details: String?,
    @SerializedName("static_fire_date_utc") var staticFireDateUtc: String?,
    @SerializedName("static_fire_date_unix") var staticFireDateUnix: Int?,
    @SerializedName("timeline") var timeline: Timeline?,
    @SerializedName("crew") var crew: ArrayList<String>?
): Parcelable