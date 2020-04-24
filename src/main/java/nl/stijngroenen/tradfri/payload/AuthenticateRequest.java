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
import nl.stijngroenen.tradfri.util.ApiCode;

/**
 * The class that contains the payload for a request to authenticate to the IKEA TRÅDFRI gateway
 * @author Stijn Groenen
 * @version 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticateRequest {

    /**
     * The identity of the client to register to the IKEA TRÅDFRI gateway
     */
    @JsonProperty(ApiCode.IDENTITY)
    private String identity;

    /**
     * Construct the AuthenticateRequest class
     * @since 1.0.0
     */
    public AuthenticateRequest(){
    }

    /**
     * Get the identity of the client to register to the IKEA TRÅDFRI gateway
     * @return The identity of the client to register to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public String getIdentity() {
        return this.identity;
    }

    /**
     * Set the identity of the client to register to the IKEA TRÅDFRI gateway
     * @param identity The new identity of the client to register to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
