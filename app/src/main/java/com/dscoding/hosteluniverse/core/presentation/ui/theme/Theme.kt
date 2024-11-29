package com.dscoding.hosteluniverse.core.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val LightColorScheme = lightColorScheme(
    primary = HuOrange,
    onPrimary = HuWhite,
    background = HuDarkGrey,
    onBackground = HuWhite,
    secondary = HuPurple,
    error = HuErrorRed
)

@Composable
fun HostelUniverseTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}