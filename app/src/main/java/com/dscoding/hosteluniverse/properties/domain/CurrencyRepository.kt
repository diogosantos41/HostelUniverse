package com.dscoding.hosteluniverse.properties.domain

import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getSelectedCurrency(): Flow<String>
    suspend fun selectCurrency(currency: String)
}