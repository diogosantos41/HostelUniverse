package com.dscoding.hosteluniverse.properties.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PropertiesResponseDto(
    val properties: List<PropertyDto>,
    val location: LocationDto
)
