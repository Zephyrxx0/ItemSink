# ItemSink

**Version**: beta-4
**Author**: Zephyrxx0

ItemSink is a Fabric mod for Minecraft 1.21.1 that changes the buoyancy of specific items, making them sink in water instead of floating.

## Features

- **Sinking Items**: Currently makes the `farmersdelight:rice_panicle` item sink by applying a gentle downward force when it's in water.
- **Physics**: Operates server-side to ensure consistent behavior across clients.
- **Future Support**: Plans to include a configuration system to allow users to specify custom items that should sink.

## Requirements

- **Minecraft**: 1.21.1
- **Fabric Loader**: >=0.18.1
- **Fabric API**: Required
- **Java**: 21 or higher

## Installation

1. Make sure you have the [Fabric Loader](https://fabricmc.net/use/installer/) installed.
2. Download the `ItemSink` jar and place it in your `.minecraft/mods` folder.
3. Ensure you have the [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) mod installed as well.

## License

This project is licensed under the CC0-1.0 License - see the [LICENSE](LICENSE) file for details.

## Development

To build the mod from source:

1. Clone the repository.
2. Run `gradlew build`.
3. The built jar will be in `build/libs`.
