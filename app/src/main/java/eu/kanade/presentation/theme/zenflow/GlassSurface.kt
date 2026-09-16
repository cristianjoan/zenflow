package eu.kanade.presentation.theme.zenflow

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.matchParentSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A dark, translucent surface for floating Zenflow content.
 *
 * GlassSurface deliberately does not use Material surface elevation. Its depth
 * comes from the translucent fill, a restrained border, and an optional tint
 * that lets an ambient background show through.
 *
 * [blurRadius] uses Compose's content blur when enabled. Keep it at zero for
 * surfaces containing readable content; it is intended for decorative or
 * lightweight glass surfaces where a softened treatment is desirable.
 */
@Composable
fun GlassSurface(
    modifier: Modifier = Modifier,
    surfaceAlpha: Float = 0.82f,
    borderWidth: Dp = 1.dp,
    borderColor: Color? = null,
    blurRadius: Dp = 0.dp,
    tintColor: Color? = null,
    tintStrength: Float = 0.14f,
    accentTint: Boolean = false,
    shape: Shape = DesignTokens.current.shapes.largeSurfaceRadius,
    content: @Composable BoxScope.() -> Unit,
) {
    val tokens = DesignTokens.current
    val colors = tokens.colors
    val resolvedTint = tintColor ?: if (accentTint) colors.accentDark else null
    val resolvedBorder = borderColor ?: colors.border
    val resolvedShape = shape
    val safeSurfaceAlpha = surfaceAlpha.coerceIn(0f, 1f)
    val safeTintStrength = tintStrength.coerceIn(0f, 1f)

    Box(
        modifier = modifier
            .clip(resolvedShape)
            .then(if (blurRadius > 0.dp) Modifier.blur(blurRadius) else Modifier)
            .background(colors.surfaceBase.copy(alpha = safeSurfaceAlpha), resolvedShape)
            .then(
                if (resolvedTint != null && safeTintStrength > 0f) {
                    Modifier.background(
                        resolvedTint.copy(alpha = safeTintStrength),
                        resolvedShape,
                    )
                } else {
                    Modifier
                },
            )
            .border(borderWidth, resolvedBorder, resolvedShape),
        content = content,
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF080808)
@Composable
private fun GlassSurfacePreview() {
    val colors = DesignTokens.current.colors
    Column(
        modifier = Modifier
            .background(colors.backgroundBase)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        GlassPreviewCard(label = "Normal glass")
        GlassPreviewCard(
            label = "Reader glass",
            surfaceAlpha = 0.56f,
            tintColor = colors.ambientCool,
            tintStrength = 0.1f,
        )
        GlassPreviewCard(
            label = "Accent tinted",
            accentTint = true,
            tintStrength = 0.22f,
            borderColor = colors.accentDark,
        )
    }
}

@Composable
private fun GlassPreviewCard(
    label: String,
    surfaceAlpha: Float = 0.82f,
    tintColor: Color? = null,
    tintStrength: Float = 0.14f,
    accentTint: Boolean = false,
    borderColor: Color? = null,
) {
    GlassSurface(
        modifier = Modifier.fillMaxWidth(),
        surfaceAlpha = surfaceAlpha,
        tintColor = tintColor,
        tintStrength = tintStrength,
        accentTint = accentTint,
        borderColor = borderColor,
        shape = DesignTokens.current.shapes.mediumSurfaceRadius,
    ) {
        Text(
            text = label,
            color = DesignTokens.current.colors.textPrimary,
            modifier = Modifier.padding(20.dp),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF141C24)
@Composable
private fun GlassSurfaceReaderPreview() {
    Box(modifier = Modifier.size(220.dp)) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(DesignTokens.current.colors.ambientWarm),
        )
        GlassSurface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            surfaceAlpha = 0.5f,
            tintColor = DesignTokens.current.colors.ambientWarm,
            tintStrength = 0.18f,
            shape = DesignTokens.current.shapes.mediumSurfaceRadius,
        ) {
            Text(
                text = "Reader controls",
                color = DesignTokens.current.colors.textPrimary,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
