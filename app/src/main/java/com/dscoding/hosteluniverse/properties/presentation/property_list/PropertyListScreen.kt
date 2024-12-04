package com.dscoding.hosteluniverse.properties.presentation.property_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dscoding.hosteluniverse.core.presentation.components.ErrorView
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi
import com.dscoding.hosteluniverse.properties.presentation.property_list.components.PropertyItem

@Composable
fun PropertyListScreenRoot(
    viewModel: PropertyListViewModel = hiltViewModel(),
    onPropertyClick: (PropertyUi) -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    PropertyListScreen(state = state, onAction = { action ->
        when (action) {
            is PropertyListAction.OnPropertyClick -> onPropertyClick(action.property)
        }
    })
}


@Composable
fun PropertyListScreen(state: PropertyListState, onAction: (PropertyListAction) -> Unit) {
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { scaffoldPadding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(scaffoldPadding)
                    .background(MaterialTheme.colorScheme.secondary.copy(0.3f)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary)
            }
        }
        if (state.errorMessage != null) {
            ErrorView(
                errorMessage = state.errorMessage.asString(context),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(scaffoldPadding)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = scaffoldPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.properties, key = { it.id }) { property ->
                    PropertyItem(
                        property = property,
                        modifier = Modifier.fillMaxWidth(),
                        onPropertyClick = { onAction(PropertyListAction.OnPropertyClick(it)) })
                }
            }
        }
    }
}