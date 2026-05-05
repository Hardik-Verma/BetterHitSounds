**BetterHitSounds v2.0.0**

BetterHitSounds is a client-side Fabric mod for Minecraft that upgrades hit feedback with custom sounds, cleaner presets, and a simple in-game setup screen.

**Main Version**

- Minecraft: `1.21.11`
- Mod Version: `2.0.0`
- Loader: `Fabric`
- Environment: `Client-side only`

**What The Mod Does**

- Replaces default hit feedback with better custom hit sounds
- Supports separate sounds for `Player` and `Mob` targets
- Supports separate sound types for `Normal`, `Combo`, and `Crit`
- Lets you choose between `OGG` playback mode and `Preset` playback mode
- Includes built-in preset sound styles, including a `Minecraft Default` preset
- Lets you preview sounds from the config screen
- Reloads imported sounds without restarting the game

**Playback Modes**

- `OGG`: uses your imported custom `.ogg` files
- `Presets`: uses built-in packaged sound styles

**OGG Folder Setup**

Place your custom sound files in these folders:

- `config/betterhitsounds/sounds/player/hit`
- `config/betterhitsounds/sounds/player/combo`
- `config/betterhitsounds/sounds/player/crit`
- `config/betterhitsounds/sounds/mob/hit`
- `config/betterhitsounds/sounds/mob/combo`
- `config/betterhitsounds/sounds/mob/crit`

Only one `.ogg` file is used per folder slot. Importing a new file replaces the old file for that slot.

**Quick Setup**

1. Open the BetterHitSounds config screen.
2. In `Options`, choose `Playback: OGG` or `Playback: Presets`.
3. If you want custom sounds, go to `Customization`.
4. Pick `Target: Player` or `Target: Mob`.
5. Pick `Sound Type: Normal`, `Combo`, or `Crit`.
6. Import one `.ogg` file for that slot.
7. Use `Preview Current OGG` to test it.
8. Hit an entity in-game to confirm everything works.

**Preset Setup**

1. Open the BetterHitSounds config screen.
2. Go to `Presets`.
3. Choose the preset you want.
4. Apply it.
5. Use the preset preview buttons to test `Hit`, `Combo`, and `Crit`.

**Config Features**

- Mod enable toggle
- Replace vanilla hit sound toggle
- Separate player and mob sound toggles
- Master volume
- Player volume
- Mob volume
- Random pitch toggle
- Minimum pitch
- Maximum pitch
- OGG or Preset playback selection

**UI Pages**

- `Options`
- `Customization`
- `Presets`
- `Guide`

**Version Copies**

Dedicated project copies were prepared for:

- `1.21.11 v2.0.0`
- `1.21.8 v2.0.0`
- `1.21.5 v2.0.0`
- `1.21.4 v2.0.0`

These version-specific copies exist to keep mixins, keybind APIs, and UI methods compatible with each Minecraft version.

**Build**

Use:

`.\gradlew.bat build`

The built jar will appear in:

`build/libs`

**GitHub**

Source:
`https://github.com/Pheonix/BetterHitSounds`

