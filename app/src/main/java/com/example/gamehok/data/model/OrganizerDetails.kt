package com.example.gamehok.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class OrganizerDetails(
    val id: String,
    val name: String,
    val profileImagePath: String
):Parcelable