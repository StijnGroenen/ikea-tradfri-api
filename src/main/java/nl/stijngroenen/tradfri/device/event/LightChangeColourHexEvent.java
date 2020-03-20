package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeColourHexEvent extends LightChangeEvent {

    public LightChangeColourHexEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public String getOldColourHex(){
        return getOldProperties().getColourHex();
    }

    public String getNewColourHex(){
        return getNewProperties().getColourHex();
    }

}
