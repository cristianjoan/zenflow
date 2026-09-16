package eu.kanade.presentation.theme.zenflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
<<<<<<< Updated upstream
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import eu.kanade.presentation.theme.zenflow.DesignColors.Companion.backgroundBase
import eu.kanade.presentation.theme.zenflow.DesignColors.Companion.backgroundHigh
import eu.kanade.presentation.theme.zenflow.DesignShapes.Companion.largeSurfaceRadius
=======
import androidx.compose.ui.graphics.RenderEffect
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import eu.kanade.presentation.theme.zenflow.DesignColors.backgroundBase
import eu.kanade.presentation.theme.zenflow.DesignShapes.largeSurfaceRadius
>>>>>>> Stashed changes

// ---------------------------------------------------------------------------
// Ambient background
// ---------------------------------------------------------------------------

/**
 * Parámetros para [AmbientBackground].
 *
 * El fondo ambiente deriva sutilmente el color del contenido principal de la
 * pantalla sobre un base near-black. El resultado debe ser lo suficientemente
 * tenue para que texto y controles sigan siendo los elementos dominantes.
 */
data class AmbientBackgroundParams(
    /**
     * Color dominante/ambiente derivado del contenido actualmente visible
     * (cover de "Continue Reading", portada de serie, artwork del reader…).
     *
     * Pasar `null` produce un fondo plano near-black sin capa ambiental.
     */
    val ambientColor: Color? = null,

    /**
     * Intensidad de la capa ambiental respecto al base. 0f = plano;
     * valores tipicos entre 0.08 y 0.22 según la pantalla.
     *
     * - Library / Series Detail: ~0.16–0.22
     * - History: ~0.05–0.08
     * - Reader (control glass sobre artwork): la artwork misma aporta el color,
     *   la capa ambiental adicional es mínima o nula.
     */
    val intensity: Float = 0.16f,

    /**
     * Si es verdadero, la capa ambiental se concentra en la mitad superior de
     * la pantalla y se desvanece hacia el fondo near-black en la parte
     * inferior. Replica el comportamiento descrito en el spec para Library y
     * Series Detail.
     */
    val fadeTowardsBottom: Boolean = true,

    /**
     * Fracción vertical (0…1) a partir de la cual el fade comienza a actuar.
     * Por defecto el fade empieza al 50 % de la altura.
     */
    val fadeStartFraction: Float = 0.5f,
)

/**
 * Fondo dinámico que deriva un color ambiental sutil desde el contenido
 * principal de la pantalla sobre un base near-black, con desvanecimiento
 * hacia negro neutro en las áreas bajas.
 *
 * ## Comportamiento
 *
 * El layer se construye conceptualmente como:
 *
 * ```text
 * base near-black (backgroundBase → backgroundHigh)
 *   + capa ambiental sutil (ambientColor × intensity) con gradiente vertical
 *     que desvanece hacia abajo si [AmbientBackgroundParams.fadeTowardsBottom]
 *   + darkening overlay mínimo para garantizar contraste del texto
 * ```
 *
 * ## Uso
 *
 * ```kotlin
 * AmbientBackground(
 *     params = AmbientBackgroundParams(
 *         ambientColor = contenidoColor,
 *         intensity = 0.18f,
 *     )
 * ) {
 *     // contenido de la pantalla
 * }
 * ```
 *
 * ## Ajuste por pantalla (spec §1.2, §2.6, §5.2, §3.2, §4.1)
 *
 * | pantalla        | intensity | fadeTowardsBottom | nota                                           |
 * |-----------------|-----------|-------------------|------------------------------------------------|
 * | Library         | 0.16–0.22 | true              | derivado del cover "Continue Reading"          |
 * | Series Detail   | 0.16–0.20 | true              | derivado del cover de la serie selecionada     |
 * | History         | 0.05–0.08 | false             | tinte muy sutil, soporta streak/status         |
 * | Reader (página) | 0.00–0.06 | false             | el artwork domina; capa adicional mínima       |
 *
 * ## No hardcodear colores de serie
 *
 * El `ambientColor` debe derivarse del contenido visible actualmente; el
 * componente no asume ningún color en particular y nunca lo elige por sí
 * mismo.
 */
@Composable
fun AmbientBackground(
    params: AmbientBackgroundParams = AmbientBackgroundParams(),
    content: @Composable () -> Unit,
) {
    Box {
        // 1. Base near-black.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = backgroundBase),
        )

        // 2. Capa ambiental opcional.
        params.ambientColor?.let { color ->
            if (params.intensity > 0f) {
                AmbientLayer(
                    ambientColor = color,
                    intensity = params.intensity.coerceIn(0f, 1f),
                    fadeTowardsBottom = params.fadeTowardsBottom,
                    fadeStartFraction = params.fadeStartFraction,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }

        // 3. Overlay oscuro sutil para mantener contraste del texto.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawRect(
                        color = Color.Black.copy(alpha = 0.12f),
                        blendMode = BlendMode.Multiply,
                    )
                },
        )

        content()
    }
}

/**
 * Capa ambiental vertical. Se dibuja como un gradiente lineal que va desde
 * el color ambiente (con la intensidad indicada) en la parte superior hasta
 * transparente en la parte inferior, permitiendo que el base near-black
 * brille por debajo.
 *
 * Cuando `fadeTowardsBottom` es verdadero, el gradiente se concentra en la
 * mitad superior y el alpha cae a cero antes de alcanzar el fondo, creando
 * la sensación de que el color "flota" sobre el contenido sin contaminar la
 * zona inferior de la pantalla.
 */
@Composable
private fun AmbientLayer(
    ambientColor: Color,
    intensity: Float,
    fadeTowardsBottom: Boolean,
    fadeStartFraction: Float,
    modifier: Modifier = Modifier,
) {
    val tinted = ambientColor.copy(alpha = intensity)

    // Construir stops de gradiente.
    val stops = buildList {
        add(0f to tinted)
        if (fadeTowardsBottom) {
            // Desde fadeStartFraction hasta 1f el alpha cae a 0.
            add(fadeStartFraction to tinted.copy(alpha = tinted.alpha * 0.6f))
            add(1f to Color.Transparent)
        } else {
            // Sin fade: gradiente sutil uniforme top→bottom manteniendo un
            // pequeño respiro hacia el fondo neutral.
            add(1f to tinted.copy(alpha = tinted.alpha * 0.5f))
        }
    }

    Box(
        modifier = modifier.background(
            brush = Brush.verticalGradient(
                colors = stops.map { it.second },
            ),
        ),
    )
}

// ---------------------------------------------------------------------------
// Glass surface
// ---------------------------------------------------------------------------

/**
 * Parámetros para [GlassSurface].
 *
 * Una superficie de vidrio oscuro: relleno translúcido, borde sutil, radio
 * de esquina grande, sin sombra dura. La profundidad se logra mediante
 * transparencia, contraste del borde y el contraste con el fondo ambiental,
 * no con sombras blur.
 *
 * ## Blur semantics
 *
 * El "efecto vidrio" se produce por la combinación de:
 * - relleno translúcido que deja ver el fondo filtrándose,
 * - borde de bajo contraste, y
 * - el contraste entre la superficie y el fondo ambiental.
 *
 * No se aplica ningún filtro de desenfoque (blur) sobre la capa de fondo.
 * Cuando el diseño requiere que el material detrás de un panel se vea suave,
 * eso se logra composicionalmente: el panel glass flota sobre el contenido y
 * su relleno semitransparente disminuye el contraste del material subyacente,
 * creando la impresión de profundidad sin necesidad de un blur explícito.
 *
 * Si en el futuro el sistema requiere blur material real (p. ej. para
 * superposiciones sobre contenido en movimiento), esa es una capa aparte
 * que debe implementarse a nivel de la pantalla o del View, no en el
 * componente de superficie base.
 */
data class GlassSurfaceParams(
    /**
     * Color de relleno del vidrio. Por defecto un blanco muy tenuemente
     * transparente para que el fondo se vea filtrado.
     */
    val fillColor: Color = Color.White.copy(alpha = 0.04f),

    /**
     * Color del borde. Por defecto un gris muy tenue; puede inyectarse un
     * tinte de acento (p. ej. `accent.copy(alpha = 0.25f)`) para que el
     * borde refleje el color ambiente.
     */
    val borderColor: Color = Color.White.copy(alpha = 0.08f),

    /**
     * Grosor del borde.
     */
    val borderWidth: Dp = 1.dp,

    /**
     * Radio de las esquinas. Por defecto usa el token de superficie grande.
     */
    val cornerRadius: Dp = largeSurfaceRadius,

    /**
     * Tinte opcional de acento que se mezcla sutilmente en el borde para
     * conectar visualmente la superficie con el color ambiente de la pantalla.
     * Se aplica como un borde adicional más interior con alpha bajo.
     */
    val accentTint: Color? = null,

    /**
     * Si es mayor que cero, añade una sombra suave y difusa bajo la superficie
     * para separarla del fondo cuando el contraste de transparencia no es
     * suficiente. La sombra es siempre muy tenue; el objetivo no es crear
     * profundidad dramática sino apenas separar la superficie del fondo.
     */
    val elevation: Dp = 0.dp,
)

/**
 * Superficie de vidrio oscuro para paneles flotantes: borde sutil, relleno
 * translúcido, esquinas grandes, profundidad por transparencia y contraste
 * en vez de sombras duras.
 *
 * ## Características de diseño (spec §1.3)
 *
 * - Relleno translúcido que deja ver el fondo ambiental filtrándose.
 * - Borde de bajo contraste (gris tenue o tinte de acento sutil).
 * - Esquinas muy redondeadas (por defecto 24 dp).
 * - Poca o ninguna sombra dura; cuando se usa elevación es mínima.
 * - No debe usarse en todas partes: el contenido y jerarquía deben mantener
 *   áreas sólidas/planas claras.
 *
 * ## Blur se produce por composición, no por filtro
 *
 * El vidrio no desenreda el fondo; su relleno semitransparente y el
 * contraste de borde son lo que dan la sensación de vidrio. Si una pantalla
 * necesita que los elementos detrás de un panel se vean suavizados, eso se
 * logra desplazando el contenido o usando capas separadas, no alterando este
 * componente.
 *
 * ## Uso básico
 *
 * ```kotlin
 * GlassSurface(
 *     params = GlassSurfaceParams(),
 * ) {
 *     Text("Contenido del panel")
 * }
 * ```
 *
 * ## Con tinte de acento (recomendado cuando hay color ambiente)
 *
 * ```kotlin
 * GlassSurface(
 *     params = GlassSurfaceParams(
 *         accentTint = ThemeTokens.colors.accent.copy(alpha = 0.22f),
 *         borderColor = ThemeTokens.colors.border,
 *     ),
 * ) {
 *     // …
 * }
 * ```
 */
@Composable
fun GlassSurface(
    params: GlassSurfaceParams = GlassSurfaceParams(),
    content: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(params.cornerRadius)

    Box(
        modifier = Modifier
            .then(
                if (params.elevation > 0.dp) {
                    Modifier.shadow(
                        elevation = params.elevation,
                        shape = shape,
                        ambientColor = Color.Black.copy(alpha = 0.35f),
                        spotColor = Color.Black.copy(alpha = 0.20f),
                    )
                } else {
                    Modifier
                },
<<<<<<< Updated upstream
            )
            .background(
                color = params.fillColor,
                shape = shape,
            )
            .drawBorders(
=======
            ),
        content = {
            // Capa de relleno translúcido con blur opcional, dibujada por
            // separado para que el desenfoque solo afecte al relleno y no al
            // contenido ni a los bordes.
            if (params.blur > 0.dp) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            renderEffect = BlurEffect(
                                params.blur.toPx(),
                                params.blur.toPx(),
                                TileMode.Clamp,
                            )
                        },
                ) {
                    drawRoundRect(
                        color = params.fillColor,
                        cornerRadius = CornerRadius(params.cornerRadius.toPx(), params.cornerRadius.toPx()),
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = params.fillColor,
                            shape = shape,
                        ),
                )
            }

            // Bordes sobre el relleno (sin blur).
            drawBordersLayer(
>>>>>>> Stashed changes
                shape = shape,
                borderColor = params.borderColor,
                borderWidth = params.borderWidth,
                accentTint = params.accentTint,
            ),
        content = content,
    )
}

// ---------------------------------------------------------------------------
// Helpers de dibujo
// ---------------------------------------------------------------------------

/**
 * Dibuja uno o dos bordes concéntricos (base + acento opcional) sobre el
 * [DrawScope] actual usando la [RoundedCornerShape] indicada.
 */
private fun Modifier.drawBorders(
    shape: RoundedCornerShape,
    borderColor: Color,
    borderWidth: Dp,
    accentTint: Color?,
) = this.drawBehind {
    val borderWidthPx = borderWidth.toPx()
    val cornerRadiusPx = shape.topStart.toPx(size, this)
    val cornerRadius = CornerRadius(cornerRadiusPx, cornerRadiusPx)
    val accentOffset = borderWidthPx / 2f

    // Borde base.
    drawRoundRect(
        color = borderColor,
        cornerRadius = cornerRadius,
        style = Stroke(width = borderWidthPx),
    )

    // Borde de acento.
    accentTint?.let { tint ->
        val accentRadius = CornerRadius(
            (cornerRadiusPx - accentOffset).coerceAtLeast(0f),
            (cornerRadiusPx - accentOffset).coerceAtLeast(0f),
        )
        drawRoundRect(
            color = tint,
            cornerRadius = accentRadius,
            style = Stroke(width = borderWidthPx / 2f),
        )
    }
}
