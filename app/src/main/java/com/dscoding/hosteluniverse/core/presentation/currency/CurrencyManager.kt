package com.dscoding.hosteluniverse.core.presentation.currency

import com.dscoding.hosteluniverse.core.domain.exchange_rates.ExchangeRatesDataSource
import com.dscoding.hosteluniverse.core.domain.utils.onError
import com.dscoding.hosteluniverse.core.domain.utils.onSuccess
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class CurrencyManager @Inject constructor(private val exchangeRatesDataSource: ExchangeRatesDataSource) {

    private val currencySymbolsMap = mapOf(
        "EUR" to '€',
        "GBP" to '£',
        "USD" to '$'
    )

    suspend fun formatCurrencyAmount(currency: String, value: Double): String {
        var formattedAmount = "0.0"
        coroutineScope {
            exchangeRatesDataSource
                .getExchangeRates()
                .onSuccess { exchangeRates ->
                    val exchangeRate = (exchangeRates.find { it.key == currency }?.value
                        ?: 0.0)
                    formattedAmount = value.times(exchangeRate).toString()
                }
                .onError {
                    formattedAmount = "0.0"
                }
        }
        return "${currencySymbolsMap[currency]} $formattedAmount"
    }
}
