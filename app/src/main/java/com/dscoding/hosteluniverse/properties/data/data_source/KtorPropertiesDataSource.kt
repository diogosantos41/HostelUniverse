package com.dscoding.hosteluniverse.properties.data.data_source

import com.dscoding.hosteluniverse.core.data.constructUrl
import com.dscoding.hosteluniverse.core.data.safeCall
import com.dscoding.hosteluniverse.core.domain.DataError
import com.dscoding.hosteluniverse.core.domain.Result
import com.dscoding.hosteluniverse.core.domain.map
import com.dscoding.hosteluniverse.properties.data.mappers.toLocationString
import com.dscoding.hosteluniverse.properties.data.mappers.toProperty
import com.dscoding.hosteluniverse.properties.data.model.PropertiesResponseDto
import com.dscoding.hosteluniverse.properties.domain.PropertiesDataSource
import com.dscoding.hosteluniverse.properties.domain.model.Property
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class KtorPropertiesDataSource(private val httpClient: HttpClient) : PropertiesDataSource {
    override suspend fun getProperties(): Result<List<Property>, DataError> {
        return safeCall<PropertiesResponseDto> {
            httpClient.get(urlString = constructUrl("/properties"))
        }.map { response ->
            response.properties.map {
                it.toProperty(
                    location = response.location.toLocationString()
                )
            }
        }
    }
}