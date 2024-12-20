package com.dscoding.hosteluniverse.properties.domain.model

data class Property(
    val id: Int,
    val name: String,
    val overview: String,
    val isFeatured: Boolean,
    val location: Location,
    val overallRating: OverallRating,
    val lowestPricePerNight: PricePerNight
)
