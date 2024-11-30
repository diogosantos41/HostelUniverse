package com.dscoding.hosteluniverse.properties.domain

import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getCurrency(): Flow<String>
    suspend fun setCurrency(currency: String)
}