package eu.kanade.presentation.theme.zenflow

import androidx.compose.ui.unit.dp

/**
 * Zenflow spacing scale.
 *
 * A consistent set of spacing units used across screens and components.
 * Individual screen relationships are chosen from this scale rather than
 * hardcoding ad-hoc dp values.
 *
 * The reference screenshots determine which token applies to each gap; the
 * rule is consistency, not forcing every gap to the same value.
 */
object ZenflowSpacing {
    /** 4dp — tightest internal gaps, icon padding. */
    val space1 = 4.dp
    /** 8dp — small control gaps. */
    val space2 = 8.dp
    /** 12dp — compact component gaps. */
    val space3 = 12.dp
    /** 16dp — standard component gap, horizontal content margin base. */
    val space4 = 16.dp
    /** 20dp — medium component gap. */
    val space5 = 20.dp
    /** 24dp — section spacing, outer horizontal margin for major content. */
    val space6 = 24.dp
    /** 32dp — large section spacing and outer margins. */
    val space7 = 32.dp

    // -- Convenience aliases for readability --------------------------------
    /** 4dp */
    val xs = space1
    /** 8dp */
    val sm = space2
    /** 12dp */
    val md = space3
    /** 16dp */
    val lg = space4
    /** 20dp */
    val xl = space5
    /** 24dp */
    val xxl = space6
    /** 32dp */
    val xxxl = space7
}
