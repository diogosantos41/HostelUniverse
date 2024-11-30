package com.dscoding.hosteluniverse.properties.data.data_store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.dscoding.hosteluniverse.properties.data.data_store.DataStoreCurrencyRepository.PreferencesKeys.CURRENCY_KEY
import com.dscoding.hosteluniverse.properties.domain.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreCurrencyRepository(private val dataStore: DataStore<Preferences>) :
    CurrencyRepository {

    private object PreferencesKeys {
        val CURRENCY_KEY = stringPreferencesKey("currency")
    }

    override fun getCurrency(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[CURRENCY_KEY] ?: ""
        }
    }

    override suspend fun setCurrency(currency: String) {
        dataStore.edit { preferences ->
            preferences[CURRENCY_KEY] = currency
        }
    }
}