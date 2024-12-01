package com.dscoding.hosteluniverse.core.presentation.navigation

import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi
import kotlinx.serialization.Serializable


@Serializable
object PropertyListRoute

@Serializable
data class PropertyDetailRoute(val property: PropertyUi)