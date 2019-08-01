package com.raul.base.domain.entity.net

import com.raul.base.domain.models.ImageModel

data class ImageEntity(val url: String?)

fun ImageEntity.toModel() = ImageModel(this.url ?: "")
