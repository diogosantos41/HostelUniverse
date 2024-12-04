package com.dscoding.hosteluniverse.properties.presentation.model

import com.dscoding.hosteluniverse.properties.domain.model.Property
import kotlinx.serialization.Serializable

@Serializable
data class PropertyUi(
    val id: Int,
    val name: String,
    val overview: String,
    val isFeatured: Boolean,
    val lowestPricePerNight: String,
    val location: String,
    val rating: String,
    val numberOfRatings: String
)

fun Property.toPropertyUi() : PropertyUi {
    return PropertyUi(
        id = id,
        name = name,
        overview = overview,
        isFeatured = isFeatured,
        lowestPricePerNight = "€ " + lowestPricePerNight.value,
        location = "${location.name}, ${location.country}",
        rating = (overallRating.overall.toDouble() / 10).toString(),
        numberOfRatings = overallRating.numberOfRatings
    )
}
