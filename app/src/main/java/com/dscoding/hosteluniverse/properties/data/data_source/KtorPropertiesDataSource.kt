package com.dscoding.hosteluniverse.properties.data.data_source

import com.dscoding.hosteluniverse.core.domain.utils.DataError
import com.dscoding.hosteluniverse.core.domain.utils.Result
import com.dscoding.hosteluniverse.properties.domain.PropertiesDataSource
import com.dscoding.hosteluniverse.properties.domain.model.Location
import com.dscoding.hosteluniverse.properties.domain.model.OverallRating
import com.dscoding.hosteluniverse.properties.domain.model.PricePerNight
import com.dscoding.hosteluniverse.properties.domain.model.Property
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class KtorPropertiesDataSource(private val httpClient: HttpClient) : PropertiesDataSource {
    override suspend fun getProperties(): Result<List<Property>, DataError> {
        /* return safeCall<PropertiesResponseDto> {
            val path = "a1517b9da90dd6877385a65f324ffbc3/raw/058e83aa802907cb0032a15ca9054da563138541/properties.json"
            httpClient.get(urlString = constructUrl(path))
        }.map { response ->
            response.properties.map {
                it.toProperty(
                    location = response.location
                )
            }
        }
         */

        delay(2000)
        val properties = listOf(
            Property(
                id = 0,
                name = "Kinlay House",
                overview = "Accommodating backpackers and travellers from all over the world for nearly 25 years, Kinlay House is the place to stay in Dublin.",
                isFeatured = true,
                location = Location(name = "Dublin", country = "Ireland"),
                overallRating = OverallRating(overall = 75, numberOfRatings = "1250"),
                lowestPricePerNight = PricePerNight(value = "12.42", currency = "EUR"),
            ),
            Property(
                id = 1,
                name = "Cedro Mansion",
                overview = "Superb place, beautiful and awesome. Good quality service and coise e tal e coiso, espetacular",
                isFeatured = false,
                location = Location(name = "Gaia", country = "Portugal"),
                overallRating = OverallRating(overall = 23, numberOfRatings = "32"),
                lowestPricePerNight = PricePerNight(value = "43.32", currency = "EUR"),
            ),
            Property(
                id = 2,
                name = "Avintes Home",
                overview = "Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum, Lorem Ipsum",
                isFeatured = true,
                location = Location(name = "Tokyo", country = "Japan"),
                overallRating = OverallRating(overall = 98, numberOfRatings = "12302"),
                lowestPricePerNight = PricePerNight(value = "204.02", currency = "EUR"),
            ),
            Property(
                id = 3,
                name = "NY Apartment",
                overview = "Accommodating more than 150 travelers yearly, this is a very fancy apartment. Lorem Ipsum, good quality, Lorem Ipsum, amazing service.",
                isFeatured = false,
                location = Location(name = "New York", country = "USA"),
                overallRating = OverallRating(overall = 82, numberOfRatings = "403"),
                lowestPricePerNight = PricePerNight(value = "104.97", currency = "EUR"),
            ),
        )
         return Result.Success(properties)
    }
}