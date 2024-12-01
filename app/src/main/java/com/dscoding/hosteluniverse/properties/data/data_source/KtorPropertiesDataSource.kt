package com.dscoding.hosteluniverse.properties.data.data_source

import com.dscoding.hosteluniverse.core.data.constructUrl
import com.dscoding.hosteluniverse.core.data.safeCall
import com.dscoding.hosteluniverse.core.domain.DataError
import com.dscoding.hosteluniverse.core.domain.Result
import com.dscoding.hosteluniverse.core.domain.map
import com.dscoding.hosteluniverse.properties.data.mappers.toProperty
import com.dscoding.hosteluniverse.properties.data.model.PropertiesResponseDto
import com.dscoding.hosteluniverse.properties.domain.PropertiesDataSource
import com.dscoding.hosteluniverse.properties.domain.model.Property
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class KtorPropertiesDataSource(private val httpClient: HttpClient) : PropertiesDataSource {
    override suspend fun getProperties(): Result<List<Property>, DataError> {
        return safeCall<PropertiesResponseDto> {
            val path = "a1517b9da90dd6877385a65f324ffbc3/raw/058e83aa802907cb0032a15ca9054da563138541/properties.json"
            httpClient.get(urlString = constructUrl(path))
        }.map { response ->
            response.properties.map {
                it.toProperty(
                    location = response.location
                )
            }
        }
    }
}