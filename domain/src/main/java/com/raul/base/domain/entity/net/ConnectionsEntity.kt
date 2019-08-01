package com.raul.base.domain.entity.net

import com.google.gson.annotations.SerializedName
import com.raul.base.domain.models.ConnectionsModel

data class ConnectionsEntity(@SerializedName("group-affiliation") val groupAffiliation: String?,
                             val relatives: String?)

fun ConnectionsEntity.toModel() = ConnectionsModel(this.groupAffiliation ?: "",
    this.relatives ?: "")
