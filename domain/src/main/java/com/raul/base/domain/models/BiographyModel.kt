package com.raul.base.domain.models

data class BiographyModel(var name: String = "",
                          var alterEgos: String = "",
                          var aliases: List<String> = arrayListOf(),
                          var placeOfBirth: String = "",
                          var firstAppearance: String = "",
                          var publisher: String = "",
                          var alignment: String = "")
