package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Plug;
import nl.stijngroenen.tradfri.device.PlugProperties;

public class PlugChangeEvent extends PlugEvent {

    private PlugProperties oldProperties;

    private PlugProperties newProperties;

    public PlugChangeEvent(Plug plug, PlugProperties oldProperties, PlugProperties newProperties) {
        super(plug);
        this.oldProperties = oldProperties;
        this.newProperties = newProperties;
    }

    public PlugProperties getOldProperties(){
        return oldProperties;
    }

    public PlugProperties getNewProperties(){
        return newProperties;
    }

}
