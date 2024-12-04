package com.dscoding.hosteluniverse.properties.presentation.property_details

import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

sealed interface PropertyDetailAction {
    data class OnPropertySelected(val property: PropertyUi) : PropertyDetailAction
    data object OnBackClick : PropertyDetailAction
}