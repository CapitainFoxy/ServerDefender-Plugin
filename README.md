# ServerDefender Plugin

**ServerDefender** is a Minecraft Java plugin designed to protect and moderate your server with various administrative functions. This plugin provides extensive protection and moderation features such as chat lockdown, server lockdown, player banning, IP banning, muting and unmuting, and an automated moderation system.

## Features

- **Kick**: Remove players from the server.
- **Ban**: Ban players from the server.
- **BanIP**: Ban a player's IP address from the server.
- **Mute**: Mute players' chat capabilities.
- **Unmute**: Restore players' chat capabilities.
- **Lockdown**: Fully lockdown the server, preventing new players from joining.
- **Chat Lockdown**: Lock down the chat, preventing players from sending messages.
- **Warn**: Warn players with a custom message.
- **AutoMod**: Enable or disable the automated moderation system.

## Installation

1. **Download the plugin files.**
2. Use [Maven](https://maven.apache.org/) to compress into a .jar file
3. **Place the `ServerDefender.jar` file into the `plugins` directory of your Minecraft server.**
4. **Restart the server.**

## Configuration

The plugin automatically creates a default `config.yml` file in the `plugins/ServerDefender` directory. You can modify the plugin settings here.

### `config.yml`

```yaml
automod:
  enabled: false
chatlockdown: false
lockdown: false
banned-words:
  - "badword1"
  - "badword2"
