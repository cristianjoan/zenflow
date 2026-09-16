package eu.kanade.presentation.theme.zenflow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Zenflow design tokens aggregated into a single composition-local value.
 *
 * Every Zenflow screen and component should read tokens from
 * `ThemeTokens.colors`, `ThemeTokens.typography`, `ThemeTokens.shapes`, or
 * `ThemeTokens.spacing` — never reference individual token objects directly.
 *
 * ## Usage
 *
 * ```kotlin
 * DesignTokens {
 *     Text(
 *         text = "Library",
 *         style = ThemeTokens.typography.screenTitle,
 *         color = ThemeTokens.colors.textPrimary,
 *     )
 * }
 * ```
 *
 * ## Scope
 *
 * These tokens cover the Zenflow redesign visual language (§7 of the design
 * spec): colors, typography, shapes, and spacing. Existing Material3
 * `ColorScheme`/`Typography`/`Shapes` are left untouched so the rest of the
 * app continues to work; Zenflow-specific screens consume these tokens
 * directly.
 */
val LocalDesignColors = staticCompositionLocalOf(provider = DesignColors, name = "LocalDesignColors")
val LocalDesignTypography = staticCompositionLocalOf(provider = DesignTypography, name = "LocalDesignTypography")
val LocalDesignShapes = staticCompositionLocalOf(provider = DesignShapes, name = "LocalDesignShapes")
val LocalDesignSpacing = staticCompositionLocalOf(provider = DesignSpacing, name = "LocalDesignSpacing")

/**
 * Injects Zenflow design tokens into the composition tree for the given content.
 * Wrap your Zenflow UI with this composable to make the tokens available.
 */
@Composable
fun DesignTokens(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalDesignColors provides DesignColors,
        LocalDesignTypography provides DesignTypography,
        LocalDesignShapes provides DesignShapes,
        LocalDesignSpacing provides DesignSpacing,
        content = content,
    )
}

/**
 * Static accessor for the current Zenflow design tokens.
 *
 * Access tokens via `ThemeTokens.colors`, `ThemeTokens.typography`, etc.
 */
object ThemeTokens {
    val colors: DesignColors get() = LocalDesignColors.current
    val typography: DesignTypography get() = LocalDesignTypography.current
    val shapes: DesignShapes get() = LocalDesignShapes.current
    val spacing: DesignSpacing get() = LocalDesignSpacing.current
}
