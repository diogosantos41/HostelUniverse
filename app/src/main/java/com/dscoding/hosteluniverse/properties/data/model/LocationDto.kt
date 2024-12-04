package com.dscoding.hosteluniverse.properties.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val city: CityDto,
)

@Serializable
data class CityDto(
    val id: Int,
    val name: String,
    val idCountry: Int,
    val country: String
)