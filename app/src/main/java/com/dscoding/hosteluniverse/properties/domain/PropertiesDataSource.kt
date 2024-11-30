package com.dscoding.hosteluniverse.properties.domain

import com.dscoding.hosteluniverse.core.domain.DataError
import com.dscoding.hosteluniverse.core.domain.Result
import com.dscoding.hosteluniverse.properties.domain.model.Property

interface PropertiesDataSource {
    suspend fun getProperties(): Result<List<Property>, DataError>
}