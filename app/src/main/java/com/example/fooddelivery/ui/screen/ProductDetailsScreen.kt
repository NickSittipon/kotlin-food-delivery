package com.example.fooddelivery.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fooddelivery.data.ProductPreviewState
import com.example.fooddelivery.ui.screen.components.ProductPreviewSection

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState = ProductPreviewState()
) {
    val scrollableState = rememberScrollState()
    
    Column(
        modifier = modifier.verticalScroll(scrollableState)
        
    ){
        ProductPreviewSection(
            state = productPreviewState
        )
    }

}
