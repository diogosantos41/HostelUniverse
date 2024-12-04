@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)

package com.dscoding.hosteluniverse.properties.presentation.property_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dscoding.hosteluniverse.R
import com.dscoding.hosteluniverse.core.presentation.theme.HuGrey
import com.dscoding.hosteluniverse.properties.presentation.components.PropertyDetail
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi
import com.dscoding.hosteluniverse.properties.presentation.property_details.components.PropertyCurrencyPrice

@Composable
fun PropertyDetailScreenRoot(
    property: PropertyUi,
    viewModel: PropertyDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {

    LaunchedEffect(true) {
        viewModel.onAction(PropertyDetailAction.OnPropertySelected(property))
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    PropertyDetailScreen(state = state, onAction = { action ->
        when (action) {
            is PropertyDetailAction.OnBackClick -> onBackClick()
            else -> Unit
        }
        viewModel.onAction(action)
    })
}

@Composable
fun PropertyDetailScreen(state: PropertyDetailState, onAction: (PropertyDetailAction) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = state.property?.name ?: "",
                        style = MaterialTheme.typography.headlineSmall,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                ),
                navigationIcon = {
                    IconButton(onClick = { onAction(PropertyDetailAction.OnBackClick) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.go_back),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
            )
        },
        modifier = Modifier.fillMaxWidth()
    ) { scaffoldPadding ->
        if (state.property != null) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(scaffoldPadding)
                    .padding(horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(HuGrey)
                )
                Spacer(modifier = Modifier.height(16.dp))
                PropertyDetail(state.property, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.about),
                    style = MaterialTheme.typography.headlineSmall,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = state.property.overview,
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.currency_conversion),
                    style = MaterialTheme.typography.headlineSmall,
                )
                Spacer(modifier = Modifier.height(16.dp))
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(30.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    state.formattedAmounts.forEachIndexed { index, (symbol, amount) ->
                        PropertyCurrencyPrice(symbol = symbol, amount = amount)
                        if(state.formattedAmounts.size - 1 != index) {
                            VerticalDivider(
                                color = MaterialTheme.colorScheme.onBackground.copy(
                                    alpha = 0.2f
                                )
                            )
                        }
                    }
                }

            }
        }
    }
}