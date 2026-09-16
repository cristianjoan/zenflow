package eu.kanade.presentation.theme.zenflow

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.style.TextTransform
import androidx.compose.ui.unit.em
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
object DesignTypography {

    private val Serif = GenericFontFamily.Serif
    private val Sans = GenericFontFamily.SansSerif

    // -- Editorial serif -----------------------------------------------------
    /** Large serif screen title. ~28sp, normal weight. */
    val screenTitle: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 28.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = (-0.5).em,
        )

    /** Editorial serif for prominent series titles. ~24sp. */
    val seriesTitle: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 24.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight.Medium,
        )

    /** Serif for section titles. ~20sp. */
    val sectionTitle: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 20.sp,
            lineHeight = 26.sp,
            fontWeight = FontWeight.Normal,
        )

    /** Large editorial/serif number for hero stats. ~36sp, Bold. */
    val heroNumber: TextStyle
        get() = TextStyle(
            fontFamily = Serif,
            fontSize = 36.sp,
            lineHeight = 42.sp,
            fontWeight = FontWeight.Bold,
        )

    // -- UI sans-serif -------------------------------------------------------
    /** Clean sans-serif body text. ~16sp. */
    val body: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Normal,
        )

    /** Sans-serif bold variant. ~16sp, Bold. */
    val bodyStrong: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Bold,
        )

    /** Small gray metadata text. ~12sp, SecondaryText color. */
    val metadata: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.05.em,
            color = DesignColors.textSecondary,
        )

    /** Uppercase tracked label. ~11sp, textTransform=Uppercase, letterSpacing=1.2.em. */
    val trackedLabel: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            textTransform = TextTransform.Uppercase,
            letterSpacing = 1.2.em,
        )

    /** Sans-serif label for navigation items. ~12sp. */
    val navigationLabel: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.05.em,
        )

    /** Sans-serif button label. ~14sp, SemiBold. */
    val buttonLabel: TextStyle
        get() = TextStyle(
            fontFamily = Sans,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.05.em,
        )
}
