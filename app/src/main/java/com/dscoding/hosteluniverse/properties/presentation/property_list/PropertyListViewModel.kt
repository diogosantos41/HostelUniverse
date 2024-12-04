package com.dscoding.hosteluniverse.properties.presentation.property_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscoding.hosteluniverse.R
import com.dscoding.hosteluniverse.core.domain.utils.onError
import com.dscoding.hosteluniverse.core.domain.utils.onSuccess
import com.dscoding.hosteluniverse.core.presentation.util.UiText
import com.dscoding.hosteluniverse.core.presentation.util.toUiText
import com.dscoding.hosteluniverse.properties.domain.PropertiesDataSource
import com.dscoding.hosteluniverse.properties.presentation.model.toPropertyUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel @Inject constructor(private val propertiesDataSource: PropertiesDataSource) :
    ViewModel() {

    private val _state = MutableStateFlow(PropertyListState())
    val state = _state.asStateFlow()

    init {
        loadProperties()
    }

    private fun loadProperties() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            propertiesDataSource
                .getProperties()
                .onSuccess { properties ->
                    if (properties.isEmpty()) {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                properties = emptyList(),
                                errorMessage = UiText.StringResource(id = R.string.error_empty_list)
                            )
                        }
                        return@onSuccess
                    }
                    val propertiesUi = properties.map { it.toPropertyUi() }
                    _state.update {
                        it.copy(
                            isLoading = false,
                            properties = propertiesUi,
                            errorMessage = null
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            properties = emptyList(),
                            errorMessage = error.toUiText()
                        )
                    }
                }
        }
    }
}