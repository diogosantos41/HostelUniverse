package com.dscoding.hosteluniverse.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(errorMessage: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.error.copy(0.1f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = errorMessage,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

