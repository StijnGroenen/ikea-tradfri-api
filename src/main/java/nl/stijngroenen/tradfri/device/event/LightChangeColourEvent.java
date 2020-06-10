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

import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.device.LightProperties;
import nl.stijngroenen.tradfri.util.ColourRGB;
import nl.stijngroenen.tradfri.util.ColourXY;

/**
 * The class that represents a light colour changed event that occurred to an IKEA TRÅDFRI light
 * @author Stijn Groenen
 * @version 1.1.0
 */
public class LightChangeColourEvent extends LightChangeEvent {

    /**
     * Construct the LightChangeColourEvent class
     * @param light The light for which the event occurred
     * @param oldProperties The old properties of the light (from before the event occurred)
     * @param newProperties The new properties of the light (from after the event occurred)
     * @since 1.1.0
     */
    public LightChangeColourEvent(Light light, LightProperties oldProperties, LightProperties newProperties) {
        super(light, oldProperties, newProperties);
    }

    /**
     * Get the old hue of the light (from before the event occurred)
     * @return The old hue of the light
     * @since 1.1.0
     */
    public int getOldHue(){
        return getOldProperties().getHue();
    }

    /**
     * Get the new hue of the light (from after the event occurred)
     * @return The new hue of the light
     * @since 1.1.0
     */
    public int getNewHue(){
        return getNewProperties().getHue();
    }

    /**
     * Get the old saturation of the light (from before the event occurred)
     * @return The old saturation of the light
     * @since 1.1.0
     */
    public int getOldSaturation(){
        return getOldProperties().getSaturation();
    }

    /**
     * Get the new saturation of the light (from after the event occurred)
     * @return The new saturation of the light
     * @since 1.1.0
     */
    public int getNewSaturation(){
        return getNewProperties().getSaturation();
    }

    /**
     * Get the old X value of the colour of the light (from before the event occurred)
     * @return The old X value of the colour of the light
     * @since 1.1.0
     */
    public int getOldColourX(){
        return getOldProperties().getColourX();
    }

    /**
     * Get the new X value of the colour of the light (from after the event occurred)
     * @return The new X value of the colour of the light
     * @since 1.1.0
     */
    public int getNewColourX(){
        return getNewProperties().getColourX();
    }

    /**
     * Get the old Y value of the colour of the light (from before the event occurred)
     * @return The old Y value of the colour of the light
     * @since 1.1.0
     */
    public int getOldColourY(){
        return getOldProperties().getColourY();
    }

    /**
     * Get the new Y value of the colour of the light (from after the event occurred)
     * @return The new Y value of the colour of the light
     * @since 1.1.0
     */
    public int getNewColourY(){
        return getNewProperties().getColourY();
    }

    /**
     * Get the old XY colour of the light (from before the event occurred)
     * @return The old XY colour of the light
     * @since 1.1.0
     */
    public ColourXY getOldColourXY(){
        return new ColourXY(getOldProperties().getColourX(), getOldProperties().getColourY());
    }

    /**
     * Get the new XY colour of the light (from after the event occurred)
     * @return The new XY colour of the light
     * @since 1.1.0
     */
    public ColourXY getNewColourXY(){
        return new ColourXY(getNewProperties().getColourX(), getNewProperties().getColourY());
    }

    /**
     * Get the old RGB colour of the light (from before the event occurred)
     * @return The old RGB colour of the light
     * @since 1.1.0
     */
    public ColourRGB getOldColourRGB() {
        return ColourRGB.fromHS(getOldProperties().getHue() != null ? getOldProperties().getHue() : 0, getOldProperties().getSaturation() != null ? getOldProperties().getSaturation() : 0);
    }

    /**
     * Get the new RGB colour of the light (from after the event occurred)
     * @return The new RGB colour of the light
     * @since 1.1.0
     */
    public ColourRGB getNewColourRGB() {
        return ColourRGB.fromHS(getNewProperties().getHue() != null ? getNewProperties().getHue() : 0, getNewProperties().getSaturation() != null ? getNewProperties().getSaturation() : 0);
    }

}
