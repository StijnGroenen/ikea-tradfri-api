package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeSaturationEvent extends LightChangeEvent {

    public LightChangeSaturationEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public int getOldSaturation(){
        return getOldProperties().getSaturation();
    }

    public int getNewSaturation(){
        return getNewProperties().getSaturation();
    }

}
