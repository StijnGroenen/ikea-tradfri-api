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

import nl.stijngroenen.tradfri.device.Gateway;

/**
 * The class that represents an event that occurred to an IKEA TRÅDFRI gateway
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class GatewayEvent extends Event {

    /**
     * The IKEA TRÅDFRI gateway for which the event occurred
     */
    private Gateway gateway;

    /**
     * Construct the GatewayEvent class
     * @param gateway The IKEA TRÅDFRI gateway for which the event occurred
     * @since 1.0.0
     */
    public GatewayEvent(Gateway gateway) {
        super();
        this.gateway = gateway;
    }

    /**
     * Get the IKEA TRÅDFRI gateway for which the event occurred
     * @return The IKEA TRÅDFRI gateway for which the event occurred
     * @since 1.0.0
     */
    public Gateway getGateway(){
        return this.gateway;
    }

}
