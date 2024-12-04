package com.dscoding.hosteluniverse.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi
import com.dscoding.hosteluniverse.properties.presentation.property_details.PropertyDetailScreenRoot
import com.dscoding.hosteluniverse.properties.presentation.property_list.PropertyListScreenRoot
import kotlin.reflect.typeOf

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = PropertyListRoute
    ) {
        composable<PropertyListRoute> {
            PropertyListScreenRoot(
                onPropertyClick = {
                    navController.navigate(PropertyDetailRoute(it))
                },
            )
        }

        composable<PropertyDetailRoute>(
           typeMap = mapOf(
                typeOf<PropertyUi>() to CustomNavType.PropertyUiType
            )
        ) {
            val args = it.toRoute<PropertyDetailRoute>()
            PropertyDetailScreenRoot(
                property = args.property,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}