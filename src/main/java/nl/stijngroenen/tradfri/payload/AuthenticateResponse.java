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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

/**
 * The class that contains the payload of a response to the authenticate request from the IKEA TRÅDFRI gateway
 * @author Stijn Groenen
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticateResponse {

    /**
     * The preshared key that can be used to authenticate to the IKEA TRÅDFRI gateway
     */
    @JsonProperty(ApiCode.PRESHARED_KEY)
    private String presharedKey;

    /**
     * The firmware version of the IKEA TRÅDFRI gateway
     */
    @JsonProperty(ApiCode.GATEWAY_FIRMWARE_VERSION)
    private String gatewayFirmwareVersion;

    /**
     * Construct the AuthenticateResponse class
     * @since 1.0.0
     */
    public AuthenticateResponse(){
    }

    /**
     * Get the preshared key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @return The preshared key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public String getPresharedKey() {
        return this.presharedKey;
    }

    /**
     * Get the firmware version of the IKEA TRÅDFRI gateway
     * @return The firmware version of the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public String getGatewayFirmwareVersion() {
        return this.gatewayFirmwareVersion;
    }

    /**
     * Set the preshared key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @param presharedKey The new preshared key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public void setPresharedKey(String presharedKey) {
        this.presharedKey = presharedKey;
    }

    /**
     * Set the firmware version of the IKEA TRÅDFRI gateway
     * @param gatewayFirmwareVersion The new firmware version of the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public void setGatewayFirmwareVersion(String gatewayFirmwareVersion) {
        this.gatewayFirmwareVersion = gatewayFirmwareVersion;
    }
}
