package eu.kanade.presentation.theme.zenflow

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eu.kanade.presentation.theme.zenflow.ThemeTokens.typography
import eu.kanade.presentation.theme.zenflow.ThemeTokens.colors

/**
 * Etiqueta tracked uppercase para metadata y secciones (spec §6.7).
 *
 * Small tracked uppercase utility text con noticeably increased letter spacing.
 * No bold — peso medio. Usa el token trackedLabel del sistema.
 *
 * ## Usos en el diseño
 *
 * - Library: CONTINUE READING (§2.3 section heading), MANGA • 42 CH (§2.5 metadata)
 * - Series Detail: CONTINUE READING status (§5.3), CHAPTERS / NEWEST FIRST (§5.7)
 * - History: group headers Today/Yesterday (§3.4), status labels
 * - Reader: page info subtitle (§4.2), settings labels
 */
@Composable
fun MetadataLabel(
    text: String,
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = colors.textSecondary,
) {
    androidx.compose.material3.Text(
        text = text,
        style = typography.trackedLabel,
        color = color,
        modifier = modifier,
    )
}

/** Overload que acepta Modifier de padding integrado. */
@Composable
fun RowScope.MetadataLabel(
    text: String,
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = colors.textSecondary,
) {
    MetadataLabel(
        text = text,
        modifier = modifier.padding(vertical = 2.dp),
        color = color,
    )
}
