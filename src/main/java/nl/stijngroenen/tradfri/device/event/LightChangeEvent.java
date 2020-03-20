package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;

public class LightChangeEvent extends LightEvent {

    private LightProperties oldProperties;

    private LightProperties newProperties;

    public LightChangeEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light);
        this.oldProperties = oldProperties;
        this.newProperties = newProperties;
    }

    public LightProperties getOldProperties(){
        return oldProperties;
    }

    public LightProperties getNewProperties(){
        return newProperties;
    }

}
