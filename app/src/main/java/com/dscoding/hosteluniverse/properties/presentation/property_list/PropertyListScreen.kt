package com.dscoding.hosteluniverse.properties.presentation.property_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dscoding.hosteluniverse.core.presentation.theme.HuPurple
import com.dscoding.hosteluniverse.properties.domain.model.Property
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

@Composable
fun PropertyListScreenRoot(OnPropertyClick: (property: PropertyUi) -> Unit) {
    PropertyListScreen()
}

@Composable
fun PropertyListScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(HuPurple))
}