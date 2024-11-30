package com.dscoding.hosteluniverse.properties.domain.model

data class Property(
    val id: Int,
    val name: String,
    val location: String,
    val overallRating: OverallRating,
    val lowestPricePerNight: PricePerNight
)
