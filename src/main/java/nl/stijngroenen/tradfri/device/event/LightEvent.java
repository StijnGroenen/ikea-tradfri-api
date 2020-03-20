package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;

public class LightEvent extends DeviceEvent {

    public LightEvent(Light light) {
        super(light);
    }

    public Light getLight(){
        return (Light) getDevice();
    }

}
