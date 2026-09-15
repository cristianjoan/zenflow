# OpenCode Task: Implement Zenflow Design Tokens

## Context
You are working in an Android/Kotlin/Compose project at `/c/Users/cristian/Documents/zenflow`.

The project already has a theme infrastructure:
- `app/src/main/java/eu/kanade/presentation/theme/TachiyomiTheme.kt` — main theme composable using `MaterialExpressiveTheme` + `ColorScheme` from `BaseColorScheme` subclasses
- `app/src/main/java/eu/kanade/presentation/theme/colorscheme/` — 16 `BaseColorScheme` subclasses (Tachiyomi, Catppuccin, TokyoNight, Monet, etc.)
- `app/src/main/java/tachiyomi/presentation/core/theme/Typography.kt` — a single derived `header` TextStyle
- Fonts: `GenericFontFamily.SansSerif` and `GenericFontFamily.Serif` are available (no bundled font files)
- Design spec lives at `opencode/design-spec.md`

## Goal
Create a NEW centralized design-token layer in `app/src/main/java/eu/kanade/presentation/theme/` for the Zenflow visual redesign.

THIS IS A PURE TOKEN LAYER — do NOT touch any existing files. Create NEW files only.

The existing `BaseColorScheme` → M3 `ColorScheme` pipeline stays intact. The new tokens are a PARALLEL semantic layer that Zenflow screens will consume.

## Files to Create
All under `app/src/main/java/eu/kanade/presentation/theme/`:

### 1. DesignColors.kt
A `DesignColors` object with these semantic color roles (initial approximate values from design spec §7):
- Background      Color(0xFF0D0D0F)   // near-black base
- Surface         Color(0xFF151517)   // very dark translucent gray/black
- ElevatedSurface Color(0xFF202024)   // slightly lighter dark glass
- PrimaryText     Color(0xFFF5F2F0)   // off-white/white
- SecondaryText   Color(0xFF9A999C)   // medium gray
- MutedText       Color(0xFF66666A)   // darker gray
- Border          Color(0xFF2B292C)   // subtle gray / accent-tinted dark border
- PrimaryAccent   Color(0xFFE83B3B)   // saturated warm red
- AccentDark      Color(0xFF6E2024)   // deep red

Each as a `val` of type `Color` (import `androidx.compose.ui.graphics.Color`). Include KDoc saying these are approximate initial values to be tuned visually against reference screenshots.

### 2. DesignTypography.kt
A `DesignTypography` object with 10 explicit semantic `TextStyle` roles.

Serif roles (use `GenericFontFamily.Serif`):
- `screenTitle`  — large, strong visual presence. Size ~28sp, FontWeight.Normal/Medium.
- `seriesTitle`  — editorial serif for prominent series titles. Size ~24sp.
- `sectionTitle` — serif for section titles. Size ~20sp.
- `heroNumber`   — editorial/serif for large stat numbers. Size ~36sp, FontWeight.Bold.

Sans-serif roles (use `GenericFontFamily.SansSerif`):
- `body`         — clean sans, highly legible. Size ~16sp.
- `bodyStrong`   — sans bold. Size ~16sp, FontWeight.Bold.
- `metadata`     — small sans, tracked/condensed-looking gray text. Size ~12sp. Color → SecondaryText.
- `trackedLabel` — uppercase with increased letterSpacing, restrained weight. Size ~11sp. MUST set `textTransform = TextTransform.Uppercase` and `letterSpacing = 1.2.sp`.
- `navigationLabel` — sans for nav labels. Size ~12sp.
- `buttonLabel`  — sans for buttons. Size ~14sp, FontWeight.SemiBold.

All roles: set appropriate `color` from `DesignColors` where it makes sense.

Import: `androidx.compose.ui.text.TextStyle`, `androidx.compose.ui.text.font.FontWeight`, `androidx.compose.ui.text.font.GenericFontFamily`, `androidx.compose.ui.text.style.TextTransform`, `androidx.compose.ui.unit.sp`, `androidx.compose.ui.unit.em`.

### 3. DesignShapes.kt
A `DesignShapes` object with shape/size tokens as `Dp` values:
- largeSurfaceRadius  = 24.dp
- mediumSurfaceRadius = 20.dp
- buttonRadius        = 16.dp
- smallControlRadius  = 14.dp
- pillRadius          = 999.dp

### 4. DesignSpacing.kt
A `DesignSpacing` object with the spacing scale as `Dp` values:
- space1 = 4.dp, space2 = 8.dp, space3 = 12.dp, space4 = 16.dp, space5 = 20.dp, space6 = 24.dp, space7 = 32.dp

### 5. ThemeTokens.kt
Central token helper with CompositionLocal-based access:
- `val LocalDesignColors = staticCompositionLocalOf(DesignColors)`
- `val LocalDesignTypography = staticCompositionLocalOf(DesignTypography)`
- `val LocalDesignShapes = staticCompositionLocalOf(DesignShapes)`
- `val LocalDesignSpacing = staticCompositionLocalOf(DesignSpacing)`

Composable:
```kotlin
@Composable
fun DesignTokens(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalDesignColors provides DesignColors,
        LocalDesignTypography provides DesignTypography,
        LocalDesignShapes provides DesignShapes,
        LocalDesignSpacing provides DesignSpacing,
        content = content
    )
}
```

Object `ThemeTokens` with static accessors:
```kotlin
object ThemeTokens {
    val colors: DesignColors get() = LocalDesignColors.current
    val typography: DesignTypography get() = LocalDesignTypography.current
    val shapes: DesignShapes get() = LocalDesignShapes.current
    val spacing: DesignSpacing get() = LocalDesignSpacing.current
}
```

### 6. VISUAL_PALETTE.md
Short Markdown doc in the theme dir capturing: where values came from (design spec §7), color hierarchy, typography roles (serif vs sans), shapes, spacing, note that values are approximate and to be tuned against reference screenshots.

## IMPORTANT CONSTRAINTS
DO NOT:
- Modify TachiyomiTheme.kt, BaseColorScheme.kt, any existing ColorScheme subclass, or AppTheme.kt
- Modify any existing screen composables
- Add font files or font dependencies
- Change Gradle files
- Change the existing Material3 ColorScheme infrastructure
- Modify presentation-core/theme/Typography.kt

DO:
- Create EXACTLY 6 new files in `app/src/main/java/eu/kanade/presentation/theme/`
- Use official Kotlin/Compose conventions
- Keep everything at the theme layer — only theme/token code

After creating files:
1. Run `./gradlew :app:compileDebugKotlin --no-daemon` to verify compilation
2. Fix any compilation errors that arise
3. Report which files were created and the compilation result

## Verification
The code must compile cleanly. Watch for:
- Import paths
- `sp` from `androidx.compose.ui.unit.sp`
- `em` from `androidx.compose.ui.unit.em`
- `TextTransform` from `androidx.compose.ui.text.style.TextTransform`
- `GenericFontFamily.Serif` and `GenericFontFamily.SansSerif` from `androidx.compose.ui.text.font.GenericFontFamily`
