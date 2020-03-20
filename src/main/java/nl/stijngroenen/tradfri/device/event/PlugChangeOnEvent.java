package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Plug;
import nl.stijngroenen.tradfri.device.PlugProperties;

public class PlugChangeOnEvent extends PlugChangeEvent {

    public PlugChangeOnEvent(Plug plug, PlugProperties oldProperties, PlugProperties newProperties) {
        super(plug, oldProperties, newProperties);
    }

    public boolean getOldOn(){
        return getOldProperties().getOn();
    }

    public boolean getNewOn(){
        return getNewProperties().getOn();
    }

}
