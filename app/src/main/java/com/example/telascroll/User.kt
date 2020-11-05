package com.example.telascroll

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userProfileAvatar: String,
    val userId: String,
    val userMensagem: String,
    var notificacao : Int = 0
): Parcelable
