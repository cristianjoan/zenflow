package eu.kanade.presentation.theme.zenflow

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Zenflow typography tokens.
 *
 * Three typographic families are used across the app:
 * - Editorial serif for major display titles and hero numbers.
 * - Clean sans-serif for functional UI.
 * - Tracked uppercase utility text for small labels.
 *
 * Font families are resolved from the system so the app introduces no new
 * font dependencies. If a serif/sans pair already exists in the project it
 * should be reused here instead.
 */
object ZenflowTypography {

    private val Serif = FontFamily.Serif
    private val Sans = FontFamily.SansSerif

    // -- Editorial serif -----------------------------------------------------
    @Composable
    val screenTitle: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = (-1.5).sp,
        )

    @Composable
    val seriesTitle: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            fontWeight = FontWeight.Normal,
        )

    @Composable
    val sectionTitle: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 34.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Normal,
        )

    /** Large editorial number used in stats (chapter count, read count, rating). */
    @Composable
    val heroNumber: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            fontWeight = FontWeight.Normal,
        )

    // -- UI sans-serif -------------------------------------------------------
    @Composable
    val body: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Normal,
        )

    @Composable
    val bodyStrong: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Bold,
        )

    @Composable
    val navigationLabel: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.2.sp,
        )

    @Composable
    val buttonLabel: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.15.sp,
        )

    // -- Tracked uppercase utility -------------------------------------------
    /** Small uppercase label with noticeably increased letter spacing. */
    @Composable
    val metadata: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.4.sp,
        )

    @Composable
    val trackedLabel: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            textCase = androidx.compose.ui.text.TextUnit.TextCase.Uppercase,
            letterSpacing = 1.8.sp,
        )

    // -- Convenience alias ---------------------------------------------------
    /** Alias for the app's primary sans-serif body style. */
    @Composable
    val sansBody: TextStyle
        get() = body
}
