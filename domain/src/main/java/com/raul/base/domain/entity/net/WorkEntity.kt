package com.raul.base.domain.entity.net

import com.raul.base.domain.models.WorkModel

data class WorkEntity(val occupation: String?,
                      val base: String?)

fun WorkEntity.toModel() = WorkModel(this.occupation ?: "",
    this.base ?: "")
