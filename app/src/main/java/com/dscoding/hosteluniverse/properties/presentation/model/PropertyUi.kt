package com.dscoding.hosteluniverse.properties.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class PropertyUi(
    val id: String,
    val overview: String,
    val lowestPricePerNight: String,
    val location: String,
    val rating: String,
    val numberOfRatings: String
)
