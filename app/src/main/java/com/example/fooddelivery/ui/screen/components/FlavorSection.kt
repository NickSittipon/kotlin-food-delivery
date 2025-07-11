package com.example.fooddelivery.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.data.ProductFlavorState
import com.example.fooddelivery.ui.theme.AppTheme

@Composable
fun FlavorSection(
    modifier: Modifier = Modifier,
    data: List<ProductFlavorState>
) {
    Column(
        modifier = modifier
    ) {
        SectionHeader(
            title = "Add More Flavor",
            emotion = "\uD83E\uDD29"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            data.forEach { item ->
                ProductFlavorItem(
                    state = item,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String,
    emotion: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground
        )
        Text(
            text = emotion,
            style = AppTheme.typography.titleLarge,
        )
    }
}

@Composable
fun ProductFlavorItem(
    modifier: Modifier = Modifier,
    state: ProductFlavorState
) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color.LightGray,
                shape = RoundedCornerShape(28.dp)
            )
            .background(
                shape = RoundedCornerShape(28.dp),
                color = AppTheme.colors.regularSurface
            )
    ) {
        Column {
            Image(
                painter = painterResource(id = state.imgRes),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = state.name,
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.onRegularSurface
                )
                Text(
                    text = "+${state.price}",
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.onRegularSurface
                )
            }
        }
    }
}
