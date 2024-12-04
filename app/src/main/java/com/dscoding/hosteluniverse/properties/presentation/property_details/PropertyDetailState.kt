package com.dscoding.hosteluniverse.properties.presentation.property_details

import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

data class PropertyDetailState(
    val property: PropertyUi? = null,
    val formattedAmounts: List<Pair<String, String>> = emptyList()
)
