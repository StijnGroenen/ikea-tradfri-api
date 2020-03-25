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

package nl.stijngroenen.tradfri.util;

/**
 * The class that contains the credentials used to authenticate to the IKEA TRÅDFRI gateway
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class Credentials {

    /**
     * The identity that can be used to authenticate to the IKEA TRÅDFRI gateway
     */
    private String identity;

    /**
     * The key that can be used to authenticate to the IKEA TRÅDFRI gateway
     */
    private String key;

    /**
     * Construct the Credentials class
     * @param identity The identity that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @param key The key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Credentials(String identity, String key) {
        this.identity = identity;
        this.key = key;
    }

    /**
     * Construct the Credentials class
     * @since 1.0.0
     */
    public Credentials() {
    }

    /**
     * Get the identity that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @return The identity that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public String getIdentity() {
        return this.identity;
    }

    /**
     * Get the key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @return The key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Set the identity that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @param identity The new identity that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * Set the key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @param key The new key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public void setKey(String key) {
        this.key = key;
    }
}
