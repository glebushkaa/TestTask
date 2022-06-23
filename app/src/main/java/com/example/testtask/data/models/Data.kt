package com.example.testtask.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Data(
    val images : Images? = null,
    val title : String? = null,
    val id: String? = null
) : Parcelable