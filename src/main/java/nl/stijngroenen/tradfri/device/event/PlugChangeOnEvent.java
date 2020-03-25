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

import nl.stijngroenen.tradfri.device.Plug;
import nl.stijngroenen.tradfri.device.PlugProperties;

/**
 * The class that represents a plug on / off state changed event that occurred to an IKEA TRÅDFRI plug
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class PlugChangeOnEvent extends PlugChangeEvent {

    /**
     * Construct the PlugChangeOnEvent class
     * @param plug The plug for which the event occurred
     * @param oldProperties The old properties of the plug (from before the event occurred)
     * @param newProperties The new properties of the plug (from after the event occurred)
     * @since 1.0.0
     */
    public PlugChangeOnEvent(Plug plug, PlugProperties oldProperties, PlugProperties newProperties) {
        super(plug, oldProperties, newProperties);
    }

    /**
     * Get the old on / off state of the light (from before the event occurred)
     * @return The old on / off state of the light (true for on, false for off)
     * @since 1.0.0
     */
    public boolean getOldOn(){
        return getOldProperties().getOn();
    }

    /**
     * Get the new on / off state of the light (from after the event occurred)
     * @return The new on / off state of the light (true for on, false for off)
     * @since 1.0.0
     */
    public boolean getNewOn(){
        return getNewProperties().getOn();
    }

}
