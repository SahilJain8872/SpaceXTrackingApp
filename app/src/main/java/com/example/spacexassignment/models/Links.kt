package com.example.spacexassignment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links (
    @SerializedName("mission_patch") var missionPatch: String?,
    @SerializedName("mission_patch_small") var missionPatchSmall: String?,
    @SerializedName("reddit_campaign") var redditCampaign: String?,
    @SerializedName("reddit_launch") var redditLaunch: String?,
    @SerializedName("reddit_recovery") var redditRecovery: String?,
    @SerializedName("reddit_media") var redditMedia: String?,
    @SerializedName("presskit") var presskit: String?,
    @SerializedName("article_link") var articleLink: String?,
    @SerializedName("wikipedia") var wikipedia: String?,
    @SerializedName("video_link") var videoLink: String?,
    @SerializedName("youtube_id") var youtubeId: String?,
    @SerializedName("flickr_images") var flickrImages: ArrayList<String>?
): Parcelable

