package com.dscoding.hosteluniverse.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.dscoding.hosteluniverse.core.data.HttpClientFactory
import com.dscoding.hosteluniverse.properties.data.data_source.KtorPropertiesDataSource
import com.dscoding.hosteluniverse.properties.data.data_store.DataStoreCurrencyRepository
import com.dscoding.hosteluniverse.properties.domain.CurrencyRepository
import com.dscoding.hosteluniverse.properties.domain.PropertiesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "currency_preferences")

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
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }

    @Provides
    @Singleton
    fun provideCurrencyRepository(dataStore: DataStore<Preferences>): CurrencyRepository {
        return DataStoreCurrencyRepository(dataStore)
    }
}