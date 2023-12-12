package com.example.submision1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitUser(
        var username: String,
        var name: String,
        var foto: Int,
        var perusahaan: String,
        var lokasi: String,
        var repository: String,
        var pengikut: String,
        var mengikuti: String
) : Parcelable




