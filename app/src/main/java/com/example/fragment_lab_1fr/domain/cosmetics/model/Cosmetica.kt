package com.example.fragment_lab_1fr.domain.cosmetics.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Cosmetica (
    val dbIb: Long,
    val name: String,
    val desc: String,
    val createDate: String,
    val picture: Int?,
):Parcelable