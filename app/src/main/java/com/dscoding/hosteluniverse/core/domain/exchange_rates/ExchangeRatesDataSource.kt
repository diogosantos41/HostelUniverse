package com.dscoding.hosteluniverse.core.domain.exchange_rates

import com.dscoding.hosteluniverse.core.domain.exchange_rates.model.ExchangeRate
import com.dscoding.hosteluniverse.core.domain.utils.DataError
import com.dscoding.hosteluniverse.core.domain.utils.Result

interface ExchangeRatesDataSource {
    suspend fun getExchangeRates() : Result<List<ExchangeRate>, DataError>
}