package com.dscoding.hosteluniverse.properties.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val city: CityDto,
)

@Serializable
data class CityDto(
    val id: Long,
    val name: String,
    val idCountry: Long,
    val country: String
)