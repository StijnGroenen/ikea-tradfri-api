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
 * The class that contains constants for hexadecimal colour temperatures allowed by the IKEA TRÅDFRI API
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class ColourTemperatureHex {

    /**
     * Construct the ColourTemperatureHex class
     * @since 1.0.0
     */
    private ColourTemperatureHex() {
    }

    /**
     * The hexadecimal colour for the colour temperature "white"<br/>
     * <i>Value: {@value}</i>
     */
    public static final String WHITE = "f5faf6";

    /**
     * The hexadecimal colour for the colour temperature "warm"<br/>
     * <i>Value: {@value}</i>
     */
    public static final String WARM = "f1e0b5";

    /**
     * The hexadecimal colour for the colour temperature "glow"<br/>
     * <i>Value: {@value}</i>
     */
    public static final String GLOW = "efd275";

}
