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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

/**
 * The class that contains the properties of an IKEA TRÅDFRI device
 * @author Stijn Groenen
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceProperties {

    /**
     * The instance id of the device
     */
    @JsonProperty(ApiCode.INSTANCE_ID)
    private Integer instanceId;

    /**
     * Construct the DeviceProperties class
     * @since 1.0.0
     */
    public DeviceProperties(){
    }

    /**
     * Get the instance id of the device
     * @return The instance id of the device
     * @since 1.0.0
     */
    public Integer getInstanceId() {
        return this.instanceId;
    }

    /**
     * Set the instance id of the device
     * @param instanceId The instance id of the device
     * @since 1.0.0
     */
    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }
}
