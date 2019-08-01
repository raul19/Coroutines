package com.raul.base.domain.entity.net

import com.raul.base.domain.models.PowerStatsModel

data class PowerStatsEntity(val intelligence: String?,
                            val strength: String?,
                            val speed: String?,
                            val durability: String?,
                            val power: String?,
                            val combat: String?)

fun PowerStatsEntity.toModel() = PowerStatsModel(this.intelligence ?: "",
    this.strength ?: "",
    this.speed ?: "",
    this.durability ?: "",
    this.power ?: "",
    this.combat ?: "")
