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

package nl.stijngroenen.tradfri.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.device.LightProperties;
import nl.stijngroenen.tradfri.device.PlugProperties;
import nl.stijngroenen.tradfri.util.ApiCode;

/**
 * The class that contains the payload for a request to update a IKEA TRÅDFRI device
 * @author Stijn Groenen
 * @version 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceRequest {

    /**
     * The new properties of the light (if the device is a light)
     */
    @JsonProperty(ApiCode.LIGHT)
    private LightProperties[] lightProperties;

    /**
     * The new properties of the plug (if the device is a plug)
     */
    @JsonProperty(ApiCode.PLUG)
    private PlugProperties[] plugProperties;

    /**
     * Construct the DeviceRequest class
     * @since 1.0.0
     */
    public DeviceRequest(){
    }

    /**
     * Get the new properties of the light (if the device is a light)
     * @return The new properties of the light
     * @since 1.0.0
     */
    public LightProperties[] getLightProperties() {
        return this.lightProperties;
    }

    /**
     * Get the new properties of the plug (if the device is a plug)
     * @return The new properties of the plug
     * @since 1.0.0
     */
    public PlugProperties[] getPlugProperties() {
        return this.plugProperties;
    }

    /**
     * Set the new properties of the light (if the device is a light)
     * @param lightProperties The new properties of the light
     * @since 1.0.0
     */
    public void setLightProperties(LightProperties[] lightProperties) {
        this.lightProperties = lightProperties;
    }

    /**
     * Set the new properties of the plug (if the device is a plug)
     * @param plugProperties The new properties of the plug
     * @since 1.0.0
     */
    public void setPlugProperties(PlugProperties[] plugProperties) {
        this.plugProperties = plugProperties;
    }
}
