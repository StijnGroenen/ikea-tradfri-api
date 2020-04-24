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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

/**
 * The class that contains the properties of an IKEA TRÅDFRI plug
 * @author Stijn Groenen
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlugProperties extends DeviceProperties {

    /**
     * The on state of the plug (true for on, false for off)
     */
    @JsonProperty(ApiCode.ON_OFF)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Boolean on;

    /**
     * Construct the PlugProperties class
     * @since 1.0.0
     */
    public PlugProperties(){
    }

    /**
     * Get the on state of the plug
     * @return The on state of the plug (true for on, false for off)
     * @since 1.0.0
     */
    public Boolean getOn() {
        return this.on;
    }

    /**
     * Set the on state of the plug within the PlugProperties class<br>
     * <i>Note: This does not change the actual plug</i>
     * @param on The new on state for the plug (true for on, false for off)
     * @since 1.0.0
     */
    public void setOn(Boolean on) {
        this.on = on;
    }
}
