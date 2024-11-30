package com.dscoding.hosteluniverse.core.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
object PropertyListRoute

@Serializable
data class PropertyDetailRoute(val property: String)