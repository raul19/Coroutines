package com.raul.base.domain.entity.net

import com.google.gson.annotations.SerializedName
import com.raul.base.domain.models.AppearanceModel

data class AppearanceEntity(val gender: String?,
                            val race: String?,
                            val height: List<String>?,
                            val weight: List<String>?,
                            @SerializedName("eye-color") val eyeColor: String?,
                            @SerializedName("hair-color") val hairColor: String?)

fun AppearanceEntity.toModel() = AppearanceModel(this.gender ?: "",
    this.race ?: "",
    this.height ?: mutableListOf(),
    this.weight ?: mutableListOf(),
    this.eyeColor ?: "",
    this.hairColor ?: "")
