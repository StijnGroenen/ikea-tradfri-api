package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeColourTemperatureEvent extends LightChangeEvent {

    public LightChangeColourTemperatureEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    public int getOldColourTemperature(){
        return getOldProperties().getColourTemperature();
    }

    public int getNewColourTemperature(){
        return getNewProperties().getColourTemperature();
    }

}
