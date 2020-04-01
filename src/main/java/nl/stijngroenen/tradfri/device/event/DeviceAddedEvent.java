/*
   Copyright 2020 Stijn Groenen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package nl.stijngroenen.tradfri.device.event;

import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Gateway;

/**
 * The class that represents a device added event that occurred to an IKEA TRÅDFRI gateway
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class DeviceAddedEvent extends GatewayEvent {

    /**
     * The added device for which the event occurred
     */
    private Device device;

    /**
     * Construct the DeviceAddedEvent class
     * @param gateway The IKEA TRÅDFRI gateway for which the event occurred
     * @param device The added device for which the event occurred
     * @since 1.0.0
     */
    public DeviceAddedEvent(Gateway gateway, Device device) {
        super(gateway);
        this.device = device;
    }

    /**
     * Get the added device for which the event occurred
     * @return The added device for which the event occurred
     * @since 1.0.0
     */
    public Device getDevice(){
        return this.device;
    }

    /**
     * Get the id of the added device for which the event occurred
     * @return The id of the added device for which the event occurred
     * @since 1.0.0
     */
    public int getDeviceId(){
        return this.device.getInstanceId();
    }

}
