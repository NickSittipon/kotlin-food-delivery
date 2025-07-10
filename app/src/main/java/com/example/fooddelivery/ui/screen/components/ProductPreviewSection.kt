package com.example.fooddelivery.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.ui.unit.Constraints
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.layout.ContentScale


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.theme.AppTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.background



@Composable
fun ProductPreviewSection(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(IntrinsicSize.Max)
    ){
        ProductBackground(
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Content(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 24.dp)
        )
    }
}

@Composable
private fun ProductBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = AppTheme.colors.secondarySurface,
                shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
            )
    )
}


@Composable
private fun Content(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (actionBar, highlights, productImg) = createRefs()

        ActionBar(
            headline = "Mr. Sittipon",
            modifier = Modifier
                .padding(horizontal = 19.dp)
                .constrainAs(actionBar) {
                    top.linkTo((parent.top))

                }
        )
        Image(
            painter = painterResource(id = R.drawable.img_burger),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(256.dp)
                .constrainAs(productImg) {
                    end.linkTo(parent.end)
                    top.linkTo(anchor = actionBar.bottom, margin = 20.dp)
                }
        )

    }
}

@Composable
private fun ActionBar(
    modifier: Modifier = Modifier,
    headline: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = headline,
            style = AppTheme.typography.headline,
            color = AppTheme.colors.onSecondarySurface
        )

        CloseButton(modifier = Modifier.size(36.dp))
    }
}

@Composable
private fun CloseButton(
    modifier: Modifier
) {
    Surface(
        modifier = modifier.size(44.dp),
        shape = RoundedCornerShape(16.dp),
        color = AppTheme.colors.actionSurface,
        contentColor = AppTheme.colors.secondarySurface
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}