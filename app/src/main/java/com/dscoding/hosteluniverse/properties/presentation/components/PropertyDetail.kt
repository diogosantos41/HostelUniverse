package com.dscoding.hosteluniverse.properties.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dscoding.hosteluniverse.R
import com.dscoding.hosteluniverse.core.presentation.theme.HuOrange
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

@Composable
fun PropertyDetail(property: PropertyUi, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = property.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.weight(1f))
            if (property.isFeatured) {
                Text(
                    text = stringResource(R.string.featured),
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = null,
                tint = HuOrange,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = property.rating,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "(${property.numberOfRatings})",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
            Text(text = property.location, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = stringResource(R.string.from),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = property.lowestPricePerNight,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}