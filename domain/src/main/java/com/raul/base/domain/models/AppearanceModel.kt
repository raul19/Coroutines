package com.raul.base.domain.models

data class AppearanceModel(var gender: String = "",
                           var race: String = "",
                           var height: List<String> = arrayListOf(),
                           var weight: List<String> = arrayListOf(),
                           var eyeColor: String = "",
                           var hairColor: String = "")
