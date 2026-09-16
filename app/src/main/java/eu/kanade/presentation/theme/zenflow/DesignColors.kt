package eu.kanade.presentation.theme.zenflow

import androidx.compose.ui.graphics.Color

/**
 * Zenflow color tokens.
 *
 * Values are starting points derived from the reference screens and should be
 * tuned visually. The important part is the role and contrast hierarchy, not
 * the exact hex literal.
 *
 * ## Palette
 *
 * Background   #080808 – #0D0D0F  (near-black base)
 * Surface      #151517 – #1D1D20  (very dark translucent gray/black)
 * Elevated     #202024            (slightly lighter dark surface)
 * Primary text #F5F2F0 – #FFFFFF  (off-white / white)
 * Secondary    #9A999C – #B0ADB0  (medium gray)
 * Muted        #66666A            (darker gray)
 * Border       #2B292C            (subtle dark border)
 * Accent       #E83B3B            (saturated warm red)
 * Accent dark  #6E2024            (deep red)
 */
object DesignColors {

    // -- Base surfaces -------------------------------------------------------
    val backgroundBase = Color(0xFF080808)
    val backgroundHigh = Color(0xFF0D0D0F)

    val surfaceBase = Color(0xFF151517)
    val surfaceHigh = Color(0xFF1D1D20)
    val elevatedSurface = Color(0xFF202024)

    // -- Text hierarchy ------------------------------------------------------
    val textPrimary = Color(0xFFF5F2F0)
    val textPrimaryHigh = Color(0xFFFFFFFF)
    val textSecondary = Color(0xFF9A999C)
    val textSecondaryHigh = Color(0xFFB0ADB0)
    val textMuted = Color(0xFF66666A)

    // -- Borders & accents ---------------------------------------------------
    val border = Color(0xFF2B292C)
    val borderSoft = Color(0xFF232124)

    val accent = Color(0xFFE83B3B)
    val accentDark = Color(0xFF6E2024)
}
