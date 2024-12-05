package com.kyura.myproject1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    var name: String = "",
    var status: String = "",
    var photo: String = "",
    var position: String = "",
    var detail: String = ""
) : Parcelable
