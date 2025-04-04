package com.convertme.mp25_assign3

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class User(
    val name: String,
    val email: String,
    val password: String
) : Parcelable