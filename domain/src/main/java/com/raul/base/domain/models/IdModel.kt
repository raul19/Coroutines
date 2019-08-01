package com.raul.base.domain.models

data class IdModel(var response: String,
                   var id: String,
                   var name: String,
                   var image: ImageModel,
                   var powerstats : PowerStatsModel,
                   var biography : BiographyModel,
                   var appearance : AppearanceModel,
                   var work : WorkModel,
                   var connections : ConnectionsModel)
