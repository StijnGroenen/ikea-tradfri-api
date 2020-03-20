package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Plug;

public class PlugEvent extends DeviceEvent {

    public PlugEvent(Plug plug) {
        super(plug);
    }

    public Plug getPlug(){
        return (Plug) getDevice();
    }

}
