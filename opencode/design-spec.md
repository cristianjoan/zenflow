# Zenflow Visual Design Specification

## Purpose

This document defines the visual language shown in the four reference screens supplied for Zenflow:

- Library
- History
- Immersive Reader
- Series Detail

The screenshots are visual references only. Titles, covers, authors, chapters, descriptions, progress values, ratings, counts, and other content visible in them are placeholders and must remain dynamic in the application.

The goal is to reproduce the visual system and composition, not to hardcode the reference content.

---

# 1. Global Visual System

## 1.1 Overall aesthetic

Zenflow should feel like a dark editorial reading application rather than a conventional Material-style manga app.

The visual language is built from:

- near-black base backgrounds
- content-aware ambient color
- dark translucent/glass surfaces
- restrained red accent color
- large editorial typography
- a combination of serif and sans-serif typography
- small tracked uppercase labels
- strongly rounded geometry
- floating controls and navigation
- high contrast between primary content and metadata

The interface should feel layered rather than composed of flat solid cards.

## 1.2 Background system

The base background is near-black.

It must not be treated as a single flat black color across every screen.

Important screens derive a subtle ambient color from their primary content:

- Library: the dominant color of the current Continue Reading cover influences the upper background.
- Series Detail: the selected series cover influences the ambient background, creating a soft tinted glow around the header/content area.
- History: the ambient tint is much more subtle and primarily supports the streak/status content.
- Reader: the page artwork itself dominates the visual field, with dark glass controls layered on top.

Conceptually:

```text
base near-black
    + content-derived ambient color
    + blur / large soft gradient
    + darkening overlay
    = screen background
```

The ambient layer must remain subtle enough that text and controls remain dominant.

Never hardcode a specific series color as part of the screen design. The color should be derived from the currently displayed content when practical.

## 1.3 Glass surfaces

Important UI surfaces use a dark glass treatment rather than opaque Material cards.

Typical glass characteristics:

- dark translucent fill
- subtle tint from the underlying ambient background
- thin low-contrast border
- large rounded corners
- little or no traditional hard shadow
- depth primarily produced by transparency, border, contrast, and background blur

Use this treatment for major floating surfaces such as:

- Continue Reading card
- Weekly Streak card
- Reader top controls
- Reader page controls
- Reader bottom controls
- floating bottom navigation
- selected/floating action controls where appropriate

Avoid making every component a glass panel. Content and hierarchy should retain clear solid/flat areas.

## 1.4 Color roles

Approximate roles observed in the screenshots:

- Base background: near-black
- Primary surface: very dark translucent gray/black
- Secondary/elevated surface: slightly lighter dark glass
- Primary accent: saturated warm red
- Primary text: off-white/white
- Secondary text: medium gray
- Tertiary text: darker gray
- Borders: subtle gray or accent-tinted dark border
- Status accents: red, amber/yellow, and occasionally series-derived colors

The exact colors should be implemented as design tokens and tuned against the references rather than scattered as literals through the UI.

## 1.5 Typography

Typography is a major part of the visual identity.

There are three distinct typographic roles:

### Editorial serif

Used for major screen titles and prominent series titles.

Characteristics:

- high contrast serif appearance
- large size
- strong visual presence
- generally normal/medium rather than extremely heavy weight

Examples in the references include screen titles such as Library and History and the prominent series title in Series Detail.

### UI sans-serif

Used for:

- buttons
- functional labels
- list titles
- card titles
- navigation labels
- descriptive text

This should be clean and highly legible.

### Tracked uppercase utility text

Used for small labels such as:

- CONTINUE READING
- NEW / CHAPTER AVAILABLE
- MANGA / CHAPTER metadata
- CHAPTERS
- NEWEST FIRST
- status labels

These labels use uppercase text with noticeably increased letter spacing and a restrained visual weight.

## 1.6 Geometry

The application consistently uses strongly rounded corners.

Approximate visual ranges from the screenshots:

- major cards: roughly 20–28dp radius
- floating control groups: roughly 20–28dp radius
- small controls/buttons: roughly 12–18dp radius
- pills/tags: full or near-full radius
- chapter/status badges: pill/capsule or circular geometry

Use shared shape tokens rather than defining independent values screen by screen.

## 1.7 Spacing

The visual rhythm is based around small repeated spacing units, but exact values should be centralized as design tokens.

Common observed relationships include:

- small control gaps
- 12–16dp component gaps
- roughly 16–24dp section spacing
- roughly 24dp or more outer horizontal content margins for major content

The important rule is consistency rather than blindly forcing every gap to 8dp or 16dp.

---

# 2. Library Screen

## 2.1 Structure

Vertical flow:

1. system/status area
2. screen header
3. Continue Reading section
4. category navigation
5. two-column manga grid
6. floating bottom navigation

The header and content are left aligned; this is not a centered-title layout.

## 2.2 Header

The title `Library` is a large editorial serif title aligned to the left.

The right side contains three independent rounded controls:

- search
- filter/sort
- more

These controls sit in dark translucent rounded containers with subtle borders.

The controls are visually independent rather than appearing as one merged toolbar.

## 2.3 Continue Reading section

The section heading is a tracked uppercase label.

The current chapter/progress summary sits on the opposite side of the section heading.

Important: the chapter/progress summary belongs visually to the Continue Reading section, not to the global screen header.

The Continue Reading card is a large horizontal glass panel.

Composition:

- left: tall series cover
- right: textual content and reading controls

The cover has its own rounded corners and is visually separated from the surrounding glass panel.

Right-side hierarchy:

1. availability/status label in accent red and tracked uppercase
2. large series title
3. secondary series/subtitle metadata
4. reading progress visualization
5. primary Resume action

The progress visualization is a segmented/dotted horizontal indicator rather than a conventional Material progress bar.

The Resume action is a light/white pill-shaped button containing an icon followed by a label.

## 2.4 Category navigation

Categories appear as a horizontal row below Continue Reading.

The selected category is represented by:

- bright primary text
- stronger weight
- numeric count adjacent to the label
- a red underline below the complete tab area

Inactive categories use gray text and weaker contrast.

The underline should align with the tab region, not merely mimic a text underline.

## 2.5 Manga grid

The library uses a two-column vertical grid.

Each card consists of two visual areas:

1. cover image
2. metadata below the image

The cover is a tall portrait format with strongly rounded corners.

A small dark translucent chapter-count badge is positioned over the upper-left area of the cover.

Below the cover:

- series title: primary white sans-serif text
- metadata: smaller tracked/condensed-looking gray text

Example metadata structure:

```text
MANGA  •  42 CH
```

The content of those fields must come from the series model, not from the screenshot.

## 2.6 Library background behavior

The upper background subtly picks up the dominant color of the current Continue Reading artwork.

For a warm cover, the upper region becomes subtly warm/brown-red; the effect fades toward the lower black background.

This creates a soft visual connection between the featured content and the entire screen.

## 2.7 Bottom navigation

The navigation bar is a floating glass container detached from the screen edges.

It contains five evenly distributed items:

- Library
- Updates
- History
- Browse
- More

The selected item does NOT use an underline.

Instead, the selected item sits inside a distinct rounded internal capsule with:

- darker/lighter glass contrast
- brighter icon
- bright label
- centered icon and label

The capsule moves with the selected destination.

This navigation component must be shared across applicable screens.

---

# 3. History Screen

## 3.1 Structure

Vertical flow:

1. screen header
2. Weekly Streak card
3. grouped history sections
4. history entries
5. floating bottom navigation

## 3.2 Header

Large serif `History` title aligned left.

Secondary summary text sits underneath using small tracked uppercase text.

Right side includes compact rounded icon controls such as search and delete/clear.

## 3.3 Weekly Streak

The Weekly Streak component is a prominent tinted glass panel with a red-toned border.

It contains three distinct visual areas:

- left: icon inside a rounded inner tile
- center: heading and supporting text
- right: large streak count

The component feels elevated primarily through tint, border, and contrast rather than a hard drop shadow.

## 3.4 Group headers

History is divided into groups such as Today, Yesterday, and older dates.

The group header contains:

- tracked uppercase section label on the left
- horizontal divider line
- count on the right

The divider line is extremely subtle.

## 3.5 History entry

Each history entry is a wide dark glass/list surface.

Structure:

- left edge: narrow status/color indicator
- series thumbnail
- centered text block
- right-side circular progress indicator

Text hierarchy:

- title: large/bold white
- chapter: accent color or white depending on status
- time: muted gray

The chapter and time metadata are placed together with a separator.

## 3.6 Status color behavior

The progress/status visuals are not always red.

The references visibly use red and amber/yellow states.

Therefore these colors should be semantic status tokens rather than hardcoded occurrences of the primary accent.

The circular progress indicator is a ring with a dark track and a colored active segment.

---

# 4. Immersive Reader

## 4.1 Overall composition

The Reader prioritizes the page artwork over the application chrome.

The manga/page artwork fills the majority of the screen.

Reader controls float on top of the page as independent glass surfaces.

## 4.2 Top control surface

The top control surface is a floating rounded rectangle with substantial internal padding.

It includes:

- back control
- chapter title
- subtitle and page information
- bookmark action
- more action

The chapter title is a large bold sans-serif title.

The subtitle/page metadata beneath it uses tracked uppercase styling and subdued contrast.

The back/bookmark/more controls are individually contained in rounded dark controls.

## 4.3 Manga page

The page art itself is the primary visual layer.

The Reader should not introduce a strong opaque background panel around it.

The page can therefore visually extend behind the translucent UI controls.

## 4.4 Page progress control

Near the bottom is a separate floating glass surface containing:

- previous-page control
- current page number
- segmented/dotted progress indicator
- total page number
- next-page control

The active page segment uses the primary accent.

The inactive segments are subdued gray.

## 4.5 Reader tools

A second floating control surface contains four evenly distributed actions:

- Rotate
- Pages
- Crop
- Settings

Each action is vertically centered with:

- icon
- label

The visual treatment is intentionally minimal.

## 4.6 Reader relationship to the global system

The Reader uses the same glass surface language as the other screens, but with higher transparency because the underlying artwork should remain visible.

The Reader is the strongest example of the application's layered visual system.

---

# 5. Series Detail Screen

## 5.1 Overall structure

Vertical flow:

1. floating top controls
2. hero/header area
3. series metadata/tags
4. statistics
5. primary reading action
6. description
7. chapter section
8. chapter list

## 5.2 Dynamic ambient background

The Series Detail background is content-aware.

The dominant colors of the selected series cover subtly tint the upper/background region.

For a warm brown cover, the surrounding background becomes warm brown/red near the hero area and gradually fades toward near-black lower on the page.

This is a major shared design behavior and should be implemented generically from the selected series artwork.

## 5.3 Hero area

The hero area combines:

- portrait series cover on the left
- status label
- series title
- author
- genre/type tags

The cover is a visually dominant portrait element with rounded corners.

The title uses the large editorial serif style.

The small status line uses tracked uppercase typography and the accent color.

Tags use dark rounded pills with light text.

## 5.4 Statistics

Three statistics are arranged horizontally:

- chapter count
- read count
- rating

Each has:

- large value
- small tracked uppercase label

The values have an editorial appearance and use the same serif/display personality as other major numeric information.

## 5.5 Primary actions

The primary Continue action is a large red rounded button.

A separate download/action control sits immediately beside it as a smaller rounded dark/glass button.

The primary button visually dominates the row.

## 5.6 Description

The description is rendered as a large, spacious paragraph in light gray rather than cramped small body text.

Line spacing and horizontal margins are important to the visual rhythm.

## 5.7 Chapter list

The chapter section uses a heading row with:

- `CHAPTERS` on the left
- `NEWEST FIRST` on the right

The active/current chapter is visually highlighted with a dark red glass surface and subtle red border.

Inactive chapters are essentially transparent and rely on text hierarchy.

Each chapter row contains:

- chapter number
- chapter title
- relative date/progress metadata
- action/state indicator at the right

Only the current/active state receives strong container treatment.

---

# 6. Shared Components

The following components should be designed as reusable building blocks rather than rebuilt independently per screen:

## 6.1 AmbientBackground

Responsibilities:

- base near-black background
- content-derived color
- blur/soft gradient
- fade toward neutral black

Inputs should support a dominant/ambient color derived from the current screen content.

## 6.2 GlassSurface

Shared treatment for floating cards and overlays.

Should support:

- transparency
- border
- blur
- corner radius
- optional accent tint

## 6.3 FloatingBottomNavigation

Responsibilities:

- floating glass container
- five destinations
- selected destination capsule
- icon + label alignment
- animated selection transition if appropriate

The selected capsule must center its icon and label precisely.

## 6.4 RoundedIconButton

Shared for:

- search
- filter
- more
- back
- bookmark
- download
- reader controls

Should support selected/active states without creating separate ad-hoc layouts.

## 6.5 SeriesCover

Should support:

- portrait aspect ratio
- rounded clipping
- overlay badge
- adaptive sizing

## 6.6 ProgressIndicator variants

At minimum:

- segmented/dotted horizontal progress
- circular progress ring
- reader page progress

These should share semantic colors but allow different visual forms.

## 6.7 MetadataLabel

Small tracked uppercase typography for labels and metadata.

## 6.8 TagPill

Reusable dark pill for genres/types/status tags.

---

# 7. Design Tokens

Use tokens in one central theme/design-token layer. Do not scatter visual literals throughout screen code.

## Colors

Suggested starting values based on the references; these are approximate and should be tuned visually:

```text
Background          #080808 – #0D0D0F
Surface             #151517 – #1D1D20
Elevated Surface    #202024
Primary Text        #F5F2F0 – #FFFFFF
Secondary Text      #9A999C – #B0ADB0
Muted Text          #66666A
Border              #2B292C
Primary Accent      #E83B3B / warm red
Accent Dark         #6E2024 / deep red
```

Do not treat these values as immutable. The important part is the role and contrast hierarchy.

## Typography

The implementation should provide explicit semantic styles for:

```text
screenTitle
seriesTitle
sectionTitle
body
bodyStrong
metadata
trackedLabel
navigationLabel
buttonLabel
heroNumber
```

The app should use an editorial serif face for major display/title roles and a clean sans-serif family for functional UI. Where a serif/sans pair already exists in the project, reuse the existing theme rather than introducing unnecessary font dependencies.

## Shape tokens

Starting points:

```text
largeSurfaceRadius     24dp
mediumSurfaceRadius    20dp
buttonRadius           14–18dp
smallControlRadius     14–18dp
pillRadius             999dp
```

## Spacing tokens

Centralize a consistent spacing scale and adjust individual screen relationships from it rather than hardcoding ad-hoc values.

```text
space1  = 4dp
space2  = 8dp
space3  = 12dp
space4  = 16dp
space5  = 20dp
space6  = 24dp
space7  = 32dp
```

The screenshots should determine which token is used for each relationship.

---

# 8. Implementation Guidance for Zenflow

## Compose structure

Prefer adapting the existing Zenflow architecture and components rather than creating a parallel UI system.

Likely Compose patterns:

- `Box` for layered ambient backgrounds and reader overlays
- `LazyVerticalGrid` for Library
- `LazyColumn` for History and Series chapters
- `Row`/`Column` for hero/stat/metadata structures
- custom reusable glass surfaces
- a shared floating navigation component

The exact existing project architecture must be inspected before implementation.

## Dynamic data

Never hardcode screenshot content.

Examples that must remain dynamic:

- series title
- cover
- author
- genre/type tags
- chapter numbers
- progress
- rating
- history session data
- reading timestamps
- chapter availability
- page number
- total pages

The screenshots determine presentation, not data.

## Adaptive behavior

The layout should derive dimensions from available screen width rather than assuming one fixed phone resolution.

Particular attention should be paid to:

- two-column Library grid sizing
- hero cover/text relationship in Series Detail
- floating navigation margins
- reader overlays
- text wrapping
- accessibility font scaling

## Do not over-Materialize the design

The reference design should not be implemented as a collection of default Material3 cards, bottom navigation bars, tabs, and buttons with minor color changes.

Custom composables are appropriate where necessary to reproduce:

- glass surfaces
- floating navigation
- selected navigation capsule
- editorial tabs
- content-aware ambient backgrounds
- reader overlays

---

# 9. Critical Visual Details

These are the details most likely to make the implementation look wrong even when the functionality is correct.

1. The global screen background is not flat black; it can inherit a subtle ambient color from the current content.

2. Series Detail specifically derives its upper ambient tint from the selected series artwork.

3. Library derives a warm ambient tint from the featured Continue Reading artwork.

4. Important cards and controls use dark glass/translucent surfaces rather than opaque gray cards.

5. Bottom navigation is floating and rounded, not a conventional full-width Material bottom bar.

6. The selected bottom navigation item uses an internal rounded capsule, not an underline.

7. The selected item's icon and label must be centered together inside that capsule.

8. Major titles use an editorial serif treatment, while functional UI uses sans-serif typography.

9. Small utility labels rely heavily on uppercase text and letter spacing.

10. Library's `CHAPTER • PROGRESS` information belongs to the Continue Reading section header, not the global header.

11. Library uses a genuine two-column portrait grid.

12. Series covers have strong portrait proportions and rounded corners.

13. Reader controls are layered over the page artwork and remain visibly translucent.

14. The Reader uses multiple independent floating glass surfaces rather than one large bottom toolbar.

15. History uses semantic status colors for reading progress rather than forcing every state to the primary red.

16. The active chapter in Series Detail is highlighted with a subtle tinted surface/border while inactive chapters remain largely transparent.

17. The overall visual hierarchy depends on contrast, transparency, typography, and spacing more than heavy shadows.

18. Do not introduce generic Android UI styling that is not present in the references.

---

# 10. Recommended Implementation Order

1. Establish the shared visual tokens and typography.
2. Implement the ambient background/gradient system.
3. Implement the shared GlassSurface and rounded controls.
4. Implement the floating bottom navigation with precise selected-item alignment.
5. Redesign Library.
6. Redesign Series Detail and connect its ambient color to the selected series cover.
7. Redesign History and its semantic progress/status treatment.
8. Redesign the Immersive Reader and its floating overlays.
9. Test the screens together to ensure the visual system is consistent.

The redesign should be incremental and should preserve the existing Zenflow data flow, navigation, reading functionality, and domain architecture.
