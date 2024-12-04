package com.dscoding.hosteluniverse.core.data.exchange_rates.data_source

import com.dscoding.hosteluniverse.core.domain.exchange_rates.ExchangeRatesDataSource
import com.dscoding.hosteluniverse.core.domain.exchange_rates.model.ExchangeRate
import com.dscoding.hosteluniverse.core.domain.utils.DataError
import com.dscoding.hosteluniverse.core.domain.utils.Result
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class KtorExchangeRatesDataSource(private val httpClient: HttpClient) : ExchangeRatesDataSource {
    override suspend fun getExchangeRates(): Result<List<ExchangeRate>, DataError> {
        /* return safeCall<PropertiesResponseDto> {
            val path = "16e87e40ca7b9650aa8e1b936f23e14e/raw/15efd901b57c2b66bf0201ee7aa9aa2edc6df779/rates.json"
            httpClient.get(urlString = constructUrl(path))
        }.map { response ->
            response.properties.map {
                it.toProperty(
                    location = response.location
                )
            }
        }
         */

        delay(0)
        val rates = listOf(
            ExchangeRate(
                key = "EUR",
                value = 1.0,
            ),
            ExchangeRate(
                key = "GBP",
                value = 1.5,
            ),
            ExchangeRate(
                key = "USD",
                value = 0.1,
            )
        )
        return Result.Success(rates)
    }
}