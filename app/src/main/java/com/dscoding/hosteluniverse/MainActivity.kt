package com.dscoding.hosteluniverse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.dscoding.hosteluniverse.core.presentation.navigation.Navigation
import com.dscoding.hosteluniverse.core.presentation.theme.HostelUniverseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HostelUniverseTheme {
                Navigation(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}