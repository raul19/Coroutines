package com.raul.base.domain.entity.net

import com.raul.base.domain.models.*

data class IdEntity(val response: String?,
                    val id: String?,
                    val name: String?,
                    val image: ImageEntity?,
                    val powerstats: PowerStatsEntity?,
                    val biography: BiographyEntity?,
                    val appearance: AppearanceEntity?,
                    val work: WorkEntity?,
                    val connections: ConnectionsEntity?)

fun IdEntity.toModel() = IdModel(this.response ?: "",
    this.id ?: "",
    this.name ?: "",
    this.image?.toModel() ?: ImageModel(),
    this.powerstats?.toModel() ?: PowerStatsModel(),
    this.biography?.toModel() ?: BiographyModel(),
    this.appearance?.toModel() ?: AppearanceModel(),
    this.work?.toModel() ?: WorkModel(),
    this.connections?.toModel() ?: ConnectionsModel())
