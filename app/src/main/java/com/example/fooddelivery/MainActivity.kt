package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fooddelivery.data.ProductPreviewState
import com.example.fooddelivery.ui.screen.components.ProductPreviewSection
import com.example.fooddelivery.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppTheme {
                ProductPreviewSection(
                    state = ProductPreviewState()
                )
            }
        }
    }
}