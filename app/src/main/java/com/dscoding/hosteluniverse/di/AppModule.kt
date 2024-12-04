package com.dscoding.hosteluniverse.di

import com.dscoding.hosteluniverse.core.data.exchange_rates.data_source.KtorExchangeRatesDataSource
import com.dscoding.hosteluniverse.core.data.utils.HttpClientFactory
import com.dscoding.hosteluniverse.core.domain.exchange_rates.ExchangeRatesDataSource
import com.dscoding.hosteluniverse.core.presentation.currency.CurrencyManager
import com.dscoding.hosteluniverse.properties.data.data_source.KtorPropertiesDataSource
import com.dscoding.hosteluniverse.properties.domain.PropertiesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Singleton
    fun providesHttpClient(): HttpClient = HttpClientFactory.create(CIO.create())

    @Provides
    @Singleton
    fun providesPropertiesDataSource(httpClient: HttpClient): PropertiesDataSource {
        return KtorPropertiesDataSource(httpClient)
    }

    @Provides
    @Singleton
    fun providesExchangeRatesDataSource(httpClient: HttpClient): ExchangeRatesDataSource {
        return KtorExchangeRatesDataSource(httpClient)
    }

    @Provides
    @Singleton
    fun providesCurrencyManager(exchangeRatesDataSource: ExchangeRatesDataSource): CurrencyManager =
        CurrencyManager(exchangeRatesDataSource)
}