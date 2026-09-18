# no-block-delay
A minimal Fabric minecraft mod that removes the 4 tick delay when placing blocks.

## How does it work?
The mod works by injecting into the `handleInputEvents` method, in which it checks
if the `delay == 0`, if so, it sets the `@Shadow` `itemUseCooldown` to `0` and returns.
If this is not the case, it checks if the current `itemUseCooldown` is higher than
the defined `delay`, if so, it sets the `@Shadow` `itemUseCooldown` to the delay.

## Configuration
The mod uses a `noblockdelay.json` in the fabric config directory,
using
```java
FabricLoader.getInstance().getConfigDir().resolve("noblockdelay.json");
```
_This auto-generates the config file, if it doesn't already exist._

Default config file:
```json
{
  "enabled": true,
  "delay": 0
}
```
### Enabling / Disabling
You can toggle the mod, using: 
```
/noblockdelay toggle
```
_This also saves the content to the config file._

Or you can edit the `noblockdelay.json` config file directly.

### Configuring delay
You can configure the delay using:
```
/noblockdelay set <DELAY>
```
_This also saves the content to the config file._

The <DELAY> needs to be a positive integer.
