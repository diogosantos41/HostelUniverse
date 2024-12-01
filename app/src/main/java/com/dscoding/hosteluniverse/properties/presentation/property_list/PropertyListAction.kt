package com.dscoding.hosteluniverse.properties.presentation.property_list

import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

sealed interface PropertyListAction {
    data class OnPropertyClick(val property: PropertyUi): PropertyListAction
}