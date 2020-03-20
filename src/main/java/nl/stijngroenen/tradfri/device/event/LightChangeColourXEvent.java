package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeColourXEvent extends LightChangeEvent {

    public LightChangeColourXEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public int getOldColourX(){
        return getOldProperties().getColourX();
    }

    public int getNewColourX(){
        return getNewProperties().getColourX();
    }

}
