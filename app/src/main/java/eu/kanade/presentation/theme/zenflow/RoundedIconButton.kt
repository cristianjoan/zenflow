package eu.kanade.presentation.theme.zenflow

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import eu.kanade.presentation.theme.zenflow.ThemeTokens.colors
import eu.kanade.presentation.theme.zenflow.ThemeTokens.shapes

/**
 * Botón de icono redondeado compartido (spec §6.4).
 *
 * Building block para controles de icono en:
 * - Library header (search, filter/sort, more) §2.2
 * - History header (search, delete/clear) §3.2
 * - Reader top controls (back, bookmark, more) §4.2
 *
 * Soporta selected/active states parametrizados sin layouts ad-hoc separados.
 * Usa tokens de forma (buttonRadius 16dp) y color (border sutil, contrast con container).
 *
 * NO es un Material3 Button — es un Box redondeado con icono, diseñado para
 * controles flotantes y de header.
 *
 * ## Estados
 *
 * - Default: container semi-transparente, icono en textSecondary
 * - Selected/Active: container con acento sutil, icono en textPrimary
 * - Disabled: reduced opacity
 *
 * ## Integración con navegación
 *
 * El componente es agnóstico a la navegación. Para Voyager/Metro back navigation
 * se debe usar el crossfade proporcionado por el framework, no por este componente.
 */
@Composable
fun RoundedIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = false,
    active: Boolean = false,
    size: ButtonSize = ButtonSize.MEDIUM,
    containerColor: Color = if (selected || active) colors.elevatedSurface else Color.Transparent,
    iconTint: Color = if (selected || active) colors.textPrimary else colors.textSecondary,
    borderColor: Color = if (selected || active) colors.accent.copy(alpha = 0.4f) else colors.border,
) {
    val shape = RoundedCornerShape(shapes.buttonRadius)
    val (iconSize, containerSize, padding) = when (size) {
        ButtonSize.SMALL -> Triple(16.dp, 32.dp, 6.dp)
        ButtonSize.MEDIUM -> Triple(20.dp, 40.dp, 8.dp)
        ButtonSize.LARGE -> Triple(24.dp, 48.dp, 10.dp)
    }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

    Box(
        modifier = modifier
            .size(containerSize)
            .clip(shape)
            .background(
                color = if (isPressed && enabled) containerColor.copy(alpha = 0.8f) else containerColor,
            )
            .border(
                width = if (selected || active) 1.dp else 0.5.dp,
                color = borderColor,
                shape = shape,
            )
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        androidx.compose.material3.Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (enabled) iconTint else iconTint.copy(alpha = 0.38f),
            modifier = Modifier.size(iconSize),
        )
    }
}

enum class ButtonSize {
    SMALL,
    MEDIUM,
    LARGE,
}
