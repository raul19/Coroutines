package com.raul.base.domain.entity.net

import com.google.gson.annotations.SerializedName
import com.raul.base.domain.models.BiographyModel

data class BiographyEntity(@SerializedName("full-name") val name: String?,
                           @SerializedName("alter-egos") val alterEgos: String?,
                           val aliases: List<String>?,
                           @SerializedName("place-of-birth") val placeOfBirth: String?,
                           @SerializedName("first-appearance") val firstAppearance: String?,
                           val publisher: String?,
                           val alignment: String?)


fun BiographyEntity.toModel() = BiographyModel(this.name ?: "",
    this.alterEgos ?: "",
    this.aliases ?: mutableListOf(),
    this.placeOfBirth ?: "",
    this.firstAppearance ?: "",
    this.publisher ?: "",
    this.alignment ?: "")
