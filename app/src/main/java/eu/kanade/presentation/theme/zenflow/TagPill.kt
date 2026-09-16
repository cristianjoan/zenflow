package eu.kanade.presentation.theme.zenflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import eu.kanade.presentation.theme.zenflow.DesignTokens.colors
import eu.kanade.presentation.theme.zenflow.DesignTokens.shapes
import eu.kanade.presentation.theme.zenflow.DesignTokens.typography

/**
 * Pill oscuro para tags, status y metadata (spec §6.8).
 *
 * Dark pill con light text — NO es glass. Fondo oscuro sólido, texto claro.
 * Usa pillRadius token (≈999dp = full radius).
 *
 * ## Tamaños
 *
 * - Small (default): para tags en overcrowded contexts (generos, small metadata)
 * - Medium: para status pills, labels prominentes
 * - Large: para section headers con pill estilístico
 *
 * ## Usos en el diseño
 *
 * - Series Detail hero: genre/type tags (§5.3 — "dark rounded pills with light text")
 * - Series Detail statistics labels (§5.4 — tracked uppercase label bajo número grande)
 * - Reader top controls: subtitle/page metadata (§4.2)
 * - Library badges de estado
 *
 * ## Color
 *
 * Por defecto usa elevatedSurface (#202024) con textPrimary. Puede inyectarse
 * color de fondo personalizado y color de texto personalizado para variantes de estado.
 */
@Composable
fun TagPill(
    text: String,
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = colors.elevatedSurface,
    textColor: androidx.compose.ui.graphics.Color = colors.textPrimary,
    textStyle: androidx.compose.ui.text.TextStyle = typography.metadata,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(shapes.pillRadius))
            .background(color)
            .padding(horizontal = 10.dp, vertical = 4.dp),
    ) {
        androidx.compose.material3.Text(
            text = text,
            style = textStyle,
            color = textColor,
            textAlign = TextAlign.Center,
        )
    }
}

/** TagPill con tamaño ajustable. */
@Composable
fun TagPill(
    text: String,
    size: TagPillSize,
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = colors.elevatedSurface,
    textColor: androidx.compose.ui.graphics.Color = colors.textPrimary,
) {
    val (paddingHorizontal, paddingVertical, textStyle) = when (size) {
        TagPillSize.SMALL -> Triple(8.dp, 2.dp, typography.metadata)
        TagPillSize.MEDIUM -> Triple(12.dp, 5.dp, typography.buttonLabel)
        TagPillSize.LARGE -> Triple(16.dp, 8.dp, typography.navigationLabel),
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(shapes.pillRadius))
            .background(color)
            .padding(horizontal = paddingHorizontal, vertical = paddingVertical),
    ) {
        androidx.compose.material3.Text(
            text = text,
            style = textStyle,
            color = textColor,
            textAlign = TextAlign.Center,
        )
    }
}

enum class TagPillSize {
    SMALL,
    MEDIUM,
    LARGE,
}

/** TagPill como filtro de fila (para uso dentro de RowScope, alineado a baseline). */
@Composable
fun RowScope.TagPill(
    text: String,
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = colors.elevatedSurface,
    textColor: androidx.compose.ui.graphics.Color = colors.textPrimary,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(shapes.pillRadius))
            .background(color)
            .padding(horizontal = 10.dp, vertical = 4.dp),
    ) {
        androidx.compose.material3.Text(
            text = text,
            style = typography.metadata,
            color = textColor,
            textAlign = TextAlign.Center,
        )
    }
}
