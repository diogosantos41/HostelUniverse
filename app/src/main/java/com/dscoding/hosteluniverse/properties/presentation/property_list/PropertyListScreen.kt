package com.dscoding.hosteluniverse.properties.presentation.property_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dscoding.hosteluniverse.core.presentation.theme.HuPurple
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

@Composable
fun PropertyListScreenRoot(
    viewModel: PropertyListViewModel = hiltViewModel(),
    OnPropertyClick: (PropertyUi) -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val onAction = viewModel::onAction
    PropertyListScreen(state = state, onAction = onAction)
}

@Composable
fun PropertyListScreen(state: PropertyListState, onAction: (PropertyListAction) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HuPurple)
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(state.properties) { property ->
                Text(text =  property.name + property.rating + property.location)
            }
        }
    }
}