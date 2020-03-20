package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Device;

public class DeviceEvent {

    private Device device;

    public DeviceEvent(Device device) {
        this.device = device;
    }

    public Device getDevice(){
        return this.device;
    }

}
