package com.dscoding.hosteluniverse.core.data.exchange_rates.mappers

import com.dscoding.hosteluniverse.core.data.exchange_rates.model.ExchangeRatesDto
import com.dscoding.hosteluniverse.core.data.exchange_rates.model.RateDto
import com.dscoding.hosteluniverse.core.domain.exchange_rates.model.ExchangeRate

fun ExchangeRatesDto.toExchangeRates() : List<ExchangeRate> {
    return this.rates.map { it.toExchangeRate() }
}

fun RateDto.toExchangeRate() : ExchangeRate {
    return ExchangeRate(
        key = key,
        value = value
    )
}