package com.dscoding.hosteluniverse.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dscoding.hosteluniverse.properties.presentation.property_details.PropertyDetailScreenRoot
import com.dscoding.hosteluniverse.properties.presentation.property_list.PropertyListScreenRoot

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
                OnPropertyClick = {
                    navController.navigate(PropertyDetailRoute(property = "0"))
                },
            )
        }

        composable<PropertyDetailRoute>(
          //  typeMap = mapOf(
             //   typeOf<Property>() to CustomNavType.PropertyType
            //)
        ) {
            val args = it.toRoute<PropertyDetailRoute>()
            PropertyDetailScreenRoot(
              //  property = args.property,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}