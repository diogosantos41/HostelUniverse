package com.dscoding.hosteluniverse.properties.presentation.property_list

import com.dscoding.hosteluniverse.core.presentation.util.UiText
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

data class PropertyListState(
    val properties: List<PropertyUi> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null
)