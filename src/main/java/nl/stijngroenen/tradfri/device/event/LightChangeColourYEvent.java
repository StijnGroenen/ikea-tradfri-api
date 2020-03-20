package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeColourYEvent extends LightChangeEvent {

    public LightChangeColourYEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public int getOldColourY(){
        return getOldProperties().getColourY();
    }

    public int getNewColourY(){
        return getNewProperties().getColourY();
    }

}
