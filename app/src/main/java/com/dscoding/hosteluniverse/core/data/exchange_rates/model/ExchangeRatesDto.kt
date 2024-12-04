package com.dscoding.hosteluniverse.core.data.exchange_rates.model

import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRatesDto(
    val base: String,
    val rates: List<RateDto>
)

@Serializable
data class RateDto(
    val key: String,
    val value: Double
)

/*
{"success":true,
"timestamp":1710499564,
"historical":true,
"base":"EUR",
"date":"2024-03-15",
"rates":{"AED":3.999326,"AFN":
 */
