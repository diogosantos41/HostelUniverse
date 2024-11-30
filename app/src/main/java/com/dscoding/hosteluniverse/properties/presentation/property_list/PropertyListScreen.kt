package com.dscoding.hosteluniverse.properties.presentation.property_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dscoding.hosteluniverse.core.presentation.theme.HuPurple

@Composable
fun PropertyListScreenRoot(OnPropertyClick: () -> Unit) {
    PropertyListScreen()
}

@Composable
fun PropertyListScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(HuPurple))
}