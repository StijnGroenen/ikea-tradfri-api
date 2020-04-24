# ikea-tradfri-api

ikea-tradfri-api is a Java library for communicating with IKEA TRÅDFRI devices.



## Features

 - Register a new client to the IKEA TRÅDFRI gateway
 - Get a list of all devices connected to the IKEA TRÅDFRI gateway
 - Get the current state of a light
 - Change the state of a light (on / off, brightness, colour, etc.)
 - Get the current state of a plug
 - Change the state of a plug (on / off)
 - Events to automatically detect changes for devices



## How To Use

### Connect to an IKEA TRÅDFRI gateway for the first time

Import the Gateway class and the Credentials class:
```Java
import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.util.Credentials;
```

Replace 'IP_OF_THE_GATEWAY' with the IP-address of the IKEA TRÅDFRI gateway.  
Replace 'SECURITY_CODE' with the security code of the IKEA TRÅDFRI gateway. The security code can be found on the bottom of the IKEA TRÅDFRI gateway.  

The connect function returns credentials. These credentials can later be to to connect to the gateway again.  
Please store these credentials (identity and key) securely.  
The credentials expire after 6 weeks of inactivity.

```Java
Gateway gateway = new Gateway("IP_OF_THE_GATEWAY");
Credentials credentials = gateway.connect("SECURITY_CODE");
String identity = credentials.getIdentity();
String key = credentials.getKey();
```



### Connect to an IKEA TRÅDFRI gateway using credentials

Import the Gateway class and the Credentials class:

```Java
import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.util.Credentials;
```

Replace 'IP_OF_THE_GATEWAY' with the IP-address of the IKEA TRÅDFRI gateway.  
Replace 'IDENTITY' and 'KEY' with the identity and key returned when connecting for the first time.

```Java
Gateway gateway = new Gateway("IP_OF_THE_GATEWAY");
Credentials credentials = new Credentials("IDENTITY", "KEY");
gateway.connect(credentials);
```



### Get a list of all devices connected to the IKEA TRÅDFRI gateway

Import the Device class:

```Java
import nl.stijngroenen.tradfri.device.Device;
```

Get all devices connected to the IKEA TRÅDFRI gateway:

```Java
Device[] devices = gateway.getDevices();
```



### Get a device by id

Import the Device class:

```Java
import nl.stijngroenen.tradfri.device.Device;
```

Get a device by id:  
Replace 'ID' with the id of the device.

```Java
Device device = gateway.getDevice(ID);
```



### Working with lights

#### Change a property of a light

Import the Device class and the Light class:

```Java
import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Light;
```

Change a property of a light:  
Replace 'ID' with the id of the light.

```Java
Device device = gateway.getDevice(ID);
if(device.isLight()){
    Light light = device.toLight();
    light.setBrightness(128);
}
```



#### Change multiple properties of a light

Import the Device class and the Light class:

```Java
import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.util.ColourHex;
```

Change a property of a light:  
Replace 'ID' with the id of the light.

```Java
Device device = gateway.getDevice(ID);
if(device.isLight()){
    Light light = device.toLight();
    light.updateOn(true);
    light.updateBrightness(128);
    light.updateColour(ColourHex.BLUE);
    light.applyUpdates();
}
```



#### Turn on all the lights

Import the Device class and the Light class:

```Java
import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Light;
```

Turn on all the lights:

```Java
Device[] devices = gateway.getDevices();
for(Device device: devices){
    if(device.isLight()){
        Light light = device.toLight();
        light.setOn(true);
    }
}
```



### Working with plugs

#### Turn on a plug

Import the Device class and the Plug class:

```Java
import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Plug;
```

Turn on a plug:  
Replace 'ID' with the id of the plug.

```Java
Device device = gateway.getDevice(ID);
if(device.isPlug()){
    Plug plug = device.toPlug();
    plug.setOn(true);
}
```



### Working with events

#### Available events

| Device Type | Event                              | Description                                       |
| ----------- | ---------------------------------- | ------------------------------------------------- |
|             | Event                              | The parent event for all other events             |
|             | DeviceEvent                        | The parent event for all device events            |
| **Gateway** | GatewayEvent                       | The parent event for all gateway events           |
|             | DeviceAddedEvent                   | A new device is added to the IKEA TRÅDFRI gateway |
|             | DeviceRemoveEvent                  | A device is removed from the IKEA TRÅDFRI gateway |
| **Lights**  | LightEvent                         | An event occurred for the light                   |
|             | LightChangeEvent                   | The light changed                                 |
|             | LightChangeOnEvent                 | The on / off state of the light changed           |
|             | LightChangeBrightnessEvent         | The brightness of the light changed               |
|             | LightChangeColourHexEvent          | The hexadecimal colour of the light changed       |
|             | LightChangeHueEvent                | The hue of the light changed                      |
|             | LightChangeSaturationEvent         | The saturation of the light changed               |
|             | LightChangeColourXEvent            | The X value of the colour of the light changed    |
|             | LightChangeColourYEvent            | The Y value of the colour of the light changed    |
|             | LightChangeColourTemeperatureEvent | The brightness of the light changed               |
| **Plug**    | PlugEvent                          | An event occurred for the plug                    |
|             | PlugChangeEvent                    | The plug changed                                  |
|             | PlugChangeOnEvent                  | The on / off state of the light changed           |



#### Add an event handler to the IKEA TRÅDFRI gateway

Import the EventHandler class and the DeviceAddedEvent class:

```Java
import nl.stijngroenen.tradfri.device.event.EventHandler;
import nl.stijngroenen.tradfri.device.event.DeviceAddedEvent;
```

A new device is added to the IKEA TRÅDFRI gateway:

```Java
EventHandler<DeviceAddedEvent> eventHandler = new EventHandler<DeviceAddedEvent>() {
    @Override
    public void handle(DeviceAddedEvent event){
        System.out.println("A new device is added: "+event.getDevice().getName());
    }
};
gateway.enableObserve(); // This is necessary for the event handler to work.
gateway.addEventHandler(eventHandler);
```



#### Add an event handler to a device

Import the Device class, the EventHandler class and the LightChangeOnEvent class:

```Java
import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.event.EventHandler;
import nl.stijngroenen.tradfri.device.event.LightChangeOnEvent;
```

Change a property of a light:  
Replace 'ID' with the id of the light.

```Java
Device device = gateway.getDevice(ID);
EventHandler<LightChangeOnEvent> eventHandler = new EventHandler<LightChangeOnEvent>() {
    @Override
    public void handle(LightChangeOnEvent event){
        System.out.println("The light is "+(event.getNewOn() ? "on" : "off"));
    }
};
device.enableObserve(); // This is necessary for the event handler to work.
device.addEventHandler(eventHandler);
```



## Built With

* [Californium](https://www.eclipse.org/californium/) - Library for the CoAP protocol
* [Jackson Databind](https://github.com/FasterXML/jackson-databind) - Library for parsing and serializing JSON
* [Maven](https://maven.apache.org/) - Dependency Management



## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/StijnGroenen/ikea-tradfri-api/tags). 



## Authors

* **Stijn Groenen** - *Initial work* - [GitHub](https://github.com/StijnGroenen)

See also the list of [contributors](https://github.com/StijnGroenen/ikea-tradfri-api/contributors) who participated in this project.



## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details