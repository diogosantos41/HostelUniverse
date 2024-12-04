package com.dscoding.hosteluniverse.properties.data.mappers

import com.dscoding.hosteluniverse.properties.data.model.LocationDto
import com.dscoding.hosteluniverse.properties.data.model.OverallRatingDto
import com.dscoding.hosteluniverse.properties.data.model.PricePerNightDto
import com.dscoding.hosteluniverse.properties.data.model.PropertyDto
import com.dscoding.hosteluniverse.properties.domain.model.Location
import com.dscoding.hosteluniverse.properties.domain.model.OverallRating
import com.dscoding.hosteluniverse.properties.domain.model.PricePerNight
import com.dscoding.hosteluniverse.properties.domain.model.Property

fun PricePerNightDto.toPricePerNight(): PricePerNight {
    return PricePerNight(
        value = value,
        currency = currency
    )
}

fun OverallRatingDto.toOverallRating(): OverallRating {
    return OverallRating(
        overall = overall,
        numberOfRatings = numberOfRatings
    )
}

fun PropertyDto.toProperty(location: LocationDto): Property {
    return Property(
        id = id,
        name = name,
        overview = overview,
        isFeatured = isFeatured,
        location = location.toLocation(),
        overallRating = overallRating.toOverallRating(),
        lowestPricePerNight = lowestPricePerNight.toPricePerNight()
    )
}

fun LocationDto.toLocation(): Location {
    return Location(
        name = city.name,
        country = city.country
    )
}