package eu.kanade.presentation.theme.zenflow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Zenflow design tokens aggregated into a single composition-local value.
 *
 * Every Zenflow screen and component should read tokens from
 * [DesignTokens.current] instead of referencing individual token objects or
 * scattering visual literals through the UI.
 *
 * ## Usage
 *
 * ```kotlin
 * val tokens = DesignTokens.current
 * Text(
 *     text = "Library",
 *     style = tokens.typography.screenTitle,
 *     color = tokens.colors.textPrimary,
 * )
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
data class DesignTokens(
    val colors: ZenflowColors = ZenflowColors,
    val typography: ZenflowTypography = ZenflowTypography,
    val shapes: ZenflowShapes = ZenflowShapes,
    val spacing: ZenflowSpacing = ZenflowSpacing,
)

val LocalDesignTokens = staticCompositionLocalOf(
    provider = DesignTokens(),
    name = "ZenflowDesignTokens",
)

/**
 * Current design tokens, resolved from the closest [CompositionLocalProvider]
 * of [LocalDesignTokens].
 */
@Composable
inline val DesignTokens.current: DesignTokens
    get() = LocalDesignTokens.current
