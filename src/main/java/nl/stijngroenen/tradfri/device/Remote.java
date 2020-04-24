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

import nl.stijngroenen.tradfri.util.CoapClient;

/**
 * The class that represents an IKEA TRÅDFRI remote
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class Remote extends Device {

    /**
     * Construct the Remote class
     * @param name The name of the remote
     * @param creationDate The creation date of the remote
     * @param instanceId The instance id of the remote
     * @param deviceInfo The information of the device
     * @param coapClient A CoAP client that can be used to communicate with the plug using the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Remote(String name, Long creationDate, Integer instanceId, DeviceInfo deviceInfo, CoapClient coapClient){
        super(name, creationDate, instanceId, deviceInfo, coapClient);
    }

}
