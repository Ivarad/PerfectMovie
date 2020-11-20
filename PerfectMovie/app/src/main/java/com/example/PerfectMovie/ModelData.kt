package com.example.bottomnav

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelData(val title : String, val urlToImage : String, val vote_average : String, val release_date : String, val overview : String) : Parcelable

