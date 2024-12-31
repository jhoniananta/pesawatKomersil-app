package com.example.pesawatkomersil.plane

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plane(
    val name: String,
    val description: String,
    val photo: Int,
): Parcelable
