# Visual Palette — Zenflow Design Tokens

## Source

Token values were derived from **design spec §7** (approximate starting points from reference screenshots), not invented. The important part is the role and contrast hierarchy, not the exact literal — values should be tuned visually against the reference screenshots.

## Colors

| Role                | Starting value | Notes                                                |
|---------------------|----------------|------------------------------------------------------|
| Background          | `#080808`      | Near-black base; also a `#0D0D0F` high variant       |
| Surface             | `#151517`      | Very dark translucent gray/black                     |
| Surface (high)      | `#1D1D20`      | Slightly lighter surface variant                     |
| Elevated Surface    | `#202024`      | Slightly lighter dark glass for elevated surfaces    |
| Primary Text        | `#F5F2F0`      | Off-white / white                                    |
| Primary Text (high) | `#FFFFFF`      | White variant for high-contrast situations           |
| Secondary Text      | `#9A999C`      | Medium gray                                          |
| Secondary Text (hi) | `#B0ADB0`      | Lighter secondary variant                            |
| Muted Text          | `#66666A`      | Darker gray for tertiary content                     |
| Border              | `#2B292C`      | Subtle dark border                                   |
| Border (soft)       | `#232124`      | Softer border variant                                |
| Primary Accent      | `#E83B3B`      | Saturated warm red                                   |
| Accent Dark         | `#6E2024`      | Deep red                                             |

Status colors (red/amber/green for history progress) and ambient tints are **not** defined here — they belong in semantic token layers added in specific feature tasks.

## Typography

| Role             | Family | Approx. size | Weight       | Notes                                            |
|------------------|--------|--------------|--------------|--------------------------------------------------|
| `screenTitle`    | Serif  | ~28sp        | Normal       | Large editorial serif for screen titles          |
| `seriesTitle`    | Serif  | ~24sp        | Medium       | Editorial serif for prominent series titles      |
| `sectionTitle`   | Serif  | ~20sp        | Normal       | Serif for section titles                         |
| `heroNumber`     | Serif  | ~36sp        | Bold         | Large editorial number for stats                 |
| `body`           | Sans   | ~16sp        | Normal       | Clean sans for body text                         |
| `bodyStrong`     | Sans   | ~16sp        | Bold         | Sans bold variant                                |
| `metadata`       | Sans   | ~12sp        | Medium       | Gray tracked metadata; color = SecondaryText     |
| `trackedLabel`   | Sans   | ~11sp        | Medium       | Uppercase + 1.2em letter spacing                 |
| `navigationLabel`| Sans   | ~12sp        | Medium       | Sans labels for navigation                       |
| `buttonLabel`    | Sans   | ~14sp        | SemiBold     | Sans labels for buttons                          |

Editorial serif roles use `GenericFontFamily.Serif`; UI sans-serif roles use `GenericFontFamily.SansSerif`. No bundled font files are introduced.

## Shapes

| Token              | Value  | Use                              |
|--------------------|--------|----------------------------------|
| `largeSurfaceRadius`   | 24dp   | Major cards / floating surfaces  |
| `mediumSurfaceRadius`  | 20dp   | Secondary cards / elevated glass |
| `buttonRadius`         | 16dp   | Buttons                          |
| `smallControlRadius`   | 14dp   | Small controls                   |
| `pillRadius`           | 999dp  | Pills / tags / capsules          |

## Spacing

| Token      | Value | Typical use                        |
|------------|-------|------------------------------------|
| `space1`   | 4dp   | Tight gaps within small controls   |
| `space2`   | 8dp   | Small component gaps               |
| `space3`   | 12dp  | List item / card internal spacing  |
| `space4`   | 16dp  | Common component spacing           |
| `space5`   | 20dp  | Section padding / margins          |
| `space6`   | 24dp  | Section spacing                    |
| `space7`   | 32dp  | Large section / screen margins     |

## Notes

- All values are approximate. Tune against reference screenshots when implementing actual screens.
- Colors: do **not** treat these as immutable. The contrast hierarchy and role names matter more than exact hex values.
- Typography: serif is used for major display titles; sans-serif for functional UI; uppercase tracked labels for small utility text (chapter counts, labels, metadata).
- Shapes: the app consistently uses strongly rounded corners (14–24dp for surfaces, full-radius for pills).
- Spacing: use the scale consistently; do not hardcode arbitrary dp values in screen code.
