package com.dscoding.hosteluniverse.properties.presentation.property_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dscoding.hosteluniverse.core.presentation.theme.HuGrey
import com.dscoding.hosteluniverse.properties.presentation.components.PropertyDetail
import com.dscoding.hosteluniverse.properties.presentation.model.PropertyUi

@Composable
fun PropertyItem(
    property: PropertyUi,
    onPropertyClick: (PropertyUi) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.background)
            .border(
                width = 1.dp,
                color = HuGrey,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onPropertyClick(property) },
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(HuGrey)
            )
            PropertyDetail(
                property = property,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}
