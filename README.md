# no-block-delay
A minimal Fabric minecraft mod that removes the 4 tick delay when placing blocks.

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
  "enabled": true
}
```
### Enabling / Disabling
You can toggle the mod, using: 
```
/noblockdelay toggle
```
_This also saves the content to the config file._

Or you can edit the `noblockdelay.json` config file directly.
