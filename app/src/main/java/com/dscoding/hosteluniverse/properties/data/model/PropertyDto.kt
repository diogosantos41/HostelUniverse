package com.dscoding.hosteluniverse.properties.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PropertyDto(
    val id: Int,
    val name: String,
    val overview: String,
    val isFeatured: Boolean,
    val overallRating: OverallRatingDto,
    val lowestPricePerNight: PricePerNightDto
)

@Serializable
data class OverallRatingDto(
    val overall: Int, val numberOfRatings: String
)

@Serializable
data class PricePerNightDto(
    val value: String, val currency: String
)







