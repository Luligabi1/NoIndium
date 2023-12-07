# No Indium? <img src="https://imgur.com/MB3Sjpt.png" align="right" width="160"/>

[![Fabric API](https://images2.imgbox.com/8e/38/bfInI5qv_o.png)](https://www.curseforge.com/minecraft/mc-mods/fabric-api)

No Indium? is a small, jij-able mod attempting to minimize the usage of Sodium without Indium on Fabric.

## Features

- Warns users using Sodium without Indium;
- Warns users using Optifabric;
- Configurable (disable one of the previous features, remove "Proceed Anyway" button).


## Adding to your project

```
repositories {
    maven {
        url = 'https://maven.cafeteria.dev/releases/'
    }
}

dependencies {
    modImplementation "me.luligabi:NoIndium:[VERSION]"
    include "me.luligabi:NoIndium:[VERSION]"
}
```

You can check the mod's current version at [Cafeteria's Maven](https://maven.cafeteria.dev/#/releases/me/luligabi/NoIndium/).
