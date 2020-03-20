package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeHueEvent extends LightChangeEvent {

    public LightChangeHueEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public int getOldHue(){
        return getOldProperties().getHue();
    }

    public int getNewHue(){
        return getNewProperties().getHue();
    }

}
