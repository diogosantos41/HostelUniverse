package com.dscoding.hosteluniverse.properties.presentation.property_details

import androidx.lifecycle.ViewModel
import com.dscoding.hosteluniverse.core.presentation.currency.CurrencyManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PropertyDetailViewModel @Inject constructor(private val currencyManager: CurrencyManager) : ViewModel() {
    private val _state = MutableStateFlow(PropertyDetailState())
    val state = _state.asStateFlow()

    fun onAction(action: PropertyDetailAction) {
        when (action) {
            is PropertyDetailAction.OnPropertySelected -> {
                _state.update { it.copy(property = action.property) }
            }

            else -> Unit
        }
    }
}