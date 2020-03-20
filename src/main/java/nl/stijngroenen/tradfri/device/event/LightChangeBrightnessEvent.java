package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeBrightnessEvent extends LightChangeEvent {

    public LightChangeBrightnessEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public int getOldBrightness(){
        return getOldProperties().getBrightness();
    }

    public int getNewBrightness(){
        return getNewProperties().getBrightness();
    }

}
