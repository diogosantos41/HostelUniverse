package com.dscoding.hosteluniverse.properties.domain

import com.dscoding.hosteluniverse.core.domain.utils.DataError
import com.dscoding.hosteluniverse.core.domain.utils.Result
import com.dscoding.hosteluniverse.properties.domain.model.Property

interface PropertiesDataSource {
    suspend fun getProperties(): Result<List<Property>, DataError>
}