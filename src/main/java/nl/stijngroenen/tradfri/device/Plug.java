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

package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.DeviceRequest;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

/**
 * The class that represents an IKEA TRÅDFRI plug
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class Plug extends Device {

    /**
     * The current properties of the plug
     */
    private PlugProperties properties;

    /**
     * The new properties of the plug in the update queue
     */
    private PlugProperties newProperties;

    /**
     * Construct the Plug class
     * @param name The name of the plug
     * @param creationDate The creation date of the plug
     * @param instanceId The instance id of the plug
     * @param deviceInfo The information of the device
     * @param properties The properties of the plug
     * @param coapClient A CoAP client that can be used to communicate with the plug using the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Plug(String name, Long creationDate, Integer instanceId, DeviceInfo deviceInfo, PlugProperties properties, CoapClient coapClient){
        super(name, creationDate, instanceId, deviceInfo, coapClient);
        this.properties = properties;
        this.newProperties = new PlugProperties();
    }

    /**
     * Get the properties of the plug
     * @return The properties of the plug
     * @since 1.0.0
     */
    @Override
    public PlugProperties getProperties(){
        return this.properties;
    }

    /**
     * Set the properties of the plug
     * @param properties The properties of the plug
     * @since 1.0.0
     */
    @Override
    public void setProperties(DeviceProperties properties){
        if(properties instanceof PlugProperties) this.properties = (PlugProperties) properties;
    }

    /**
     * Get the on / off state of the plug
     * @return The on state of the plug (true for on, false for off)
     * @since 1.0.0
     */
    public Boolean getOn() {
        return properties.getOn();
    }

    /**
     * Update the on / off state of the plug in the update queue
     * @param on The new on / off state for the plug (true for on, false for off)
     * @since 1.0.0
     */
    public void updateOn(Boolean on) {
        newProperties.setOn(on);
    }

    /**
     * Set the on / off state of the plug
     * @param on The new on / off state for the plug (true for on, false for off)
     * @since 1.0.0
     */
    public boolean setOn(Boolean on) {
        PlugProperties newProperties = new PlugProperties();
        newProperties.setOn(on);
        return applyUpdate(newProperties);
    }

    /**
     * Apply updates to the plug
     * @param newProperties The new properties to apply to the plug
     * @return True if successfully updated the plug, false if not
     * @since 1.0.0
     */
    private boolean applyUpdate(PlugProperties newProperties) {
        DeviceRequest request = new DeviceRequest();
        request.setPlugProperties(new PlugProperties[]{newProperties});
        String response = coapClient.put(ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(getInstanceId())), request, String.class);
        return response != null;
    }

    /**
     * Apply the updates in the update queue to the plug
     * @return True if successfully updated the plug, false if not
     * @since 1.0.0
     */
    public boolean applyUpdates() {
        boolean success = applyUpdate(newProperties);
        newProperties = new PlugProperties();
        return success;
    }

}
