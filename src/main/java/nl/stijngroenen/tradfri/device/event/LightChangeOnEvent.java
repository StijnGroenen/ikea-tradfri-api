package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeOnEvent extends LightChangeEvent {

    public LightChangeOnEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public boolean getOldOn(){
        return getOldProperties().getOn();
    }

    public boolean getNewOn(){
        return getNewProperties().getOn();
    }

}
