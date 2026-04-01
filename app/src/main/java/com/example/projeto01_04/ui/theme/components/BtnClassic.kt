package com.example.projeto01_04.ui.theme.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BtnClassic(
    text: String,
    onClick : () -> Unit,
    level: Int = 1
) {

    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.95f else 1f,
        label =  "scaleAnimation"
    )
    Box(
        modifier = Modifier
            .padding(16.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .shadow(
                elevation = 10.dp,
                shape = MaterialTheme.shapes.large,
                ambientColor = MaterialTheme.colorScheme.onSurface,
                spotColor = MaterialTheme.colorScheme.onSurface
            )
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            }
            .padding(vertical = (16 * level).dp, horizontal = (32 * level).dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            letterSpacing = 1.2.sp
        )
    }


}