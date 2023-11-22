package com.example.fragment_lab_1fr.data.local.model

data class CosmeticsEntity (
    val id: Long,
    val externalId: String,
    val name: String,
    val desc: String,
    val createDate: Long,
    val picture: Int?,
)