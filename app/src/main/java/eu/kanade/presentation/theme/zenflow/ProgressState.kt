package eu.kanade.presentation.theme.zenflow

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.CornerRadius

/**
 * Estado de progreso para indicadores compartidos (spec §6.6).
 *
 * Modela tres variantes:
 *  - Segmented/dotted horizontal progress (Continue Reading section, Reader page)
 *  - Circular progress ring (History entry right-side indicator)
 *  - Reader page progress (page current/total)
 */
data class ProgressState(
    /** Progreso actual en el rango [0f, 1f]. 0f = nada completado, 1f = completo. */
    val progress: Float,

    /** Total de segmentos/step counts cuando el indicador es discreto.
     *  Por defecto es continuo (null = gradiente/segmento único).
     */
    val segmentCount: Int? = null,

    /** Estado semántico que determina el color activo.
     *  null = usar color primario genérico;일부 화면 usan semantic status colors.
     */
    val semanticState: SemanticState? = null,
) {
    val clampedProgress: Float
        get() = progress.coerceIn(0f, 1f)

    /** Índice del segmento actual (0-based) cuando `segmentCount` es conocido. */
    val activeSegmentIndex: Int
        get() = if (segmentCount != null && segmentCount > 0) {
            (clampedProgress * segmentCount).toInt().coerceIn(0, segmentCount - 1)
        } else 0
}

enum class SemanticState {
    /** En progreso, activo. Color primario. */
    Active,
    /** Completado. Puede ser verde/success o del color primario. */
    Completed,
    /** En pausa, no progresando. Color warning/amber. */
    Paused,
    /** Error, bloqueado. Color error. */
    Error,
}
