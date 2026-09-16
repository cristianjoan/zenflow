package eu.kanade.presentation.theme.zenflow

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Zenflow shape/size tokens.
 *
 * Approximate starting values from the reference screens (design spec §7).
 * Should be tuned visually against screenshots.
 */
object DesignShapes {
    /** Major cards / floating surfaces. ~24dp. */
    val largeSurfaceRadius = 24.dp
    /** Secondary cards / elevated surfaces. ~20dp. */
    val mediumSurfaceRadius = 20.dp
    /** Buttons. ~16dp. */
    val buttonRadius = 16.dp
    /** Small controls. ~14dp. */
    val smallControlRadius = 14.dp
    /** Pills / tags. Full radius. */
    val pillRadius = 999.dp
}
