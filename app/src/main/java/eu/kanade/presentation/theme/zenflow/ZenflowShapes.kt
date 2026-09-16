package eu.kanade.presentation.theme.zenflow

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Shape

/**
 * Zenflow shape tokens.
 *
 * The design uses strongly rounded corners across cards, floating surfaces,
 * and controls. Exact values are centralized here so screens and components
 * stay visually consistent.
 *
 * Ranges are approximate starting points; the reference screenshots determine
 * which token is used for each surface.
 */
object ZenflowShapes {

    /** Major cards, floating control groups, large panels. ~24dp. */
    val largeSurfaceRadius = RoundedCornerShape(24.dp)

    /** Slightly smaller elevated surfaces. ~20dp. */
    val mediumSurfaceRadius = RoundedCornerShape(20.dp)

    /** Small controls and buttons. ~14–18dp. */
    val buttonRadius = RoundedCornerShape(16.dp)

    /** Small interactive controls (pills, chips, small buttons). ~14dp. */
    val smallControlRadius = RoundedCornerShape(14.dp)

    /** Full-radius pills / tags. */
    val pillRadius = RoundedCornerShape(999.dp)

    /** Generous radius for card-like surfaces that are not the largest. ~16dp. */
    val cardRadius = RoundedCornerShape(16.dp)

    // -- Raw dp values (for Modifier.cornerSize and arithmetic) --------------
    val largeSurfaceRadiusDp = 24.dp
    val mediumSurfaceRadiusDp = 20.dp
    val buttonRadiusDp = 16.dp
    val smallControlRadiusDp = 14.dp
    val cardRadiusDp = 16.dp
    val pillRadiusDp = 999.dp
}
