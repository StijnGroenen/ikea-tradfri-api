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
 * The class that contains RGB values that make up a colour
 * @author Stijn Groenen
 * @version 1.1.0
 */
public class ColourRGB {

    /**
     * The red value of the colour
     */
    private Integer red;

    /**
     * The green value of the colour
     */
    private Integer green;

    /**
     * The blue value of the colour
     */
    private Integer blue;

    /**
     * Construct the ColourRGB class
     * @param red The red value of the colour
     * @param green The green value of the colour
     * @param blue The blue value of the colour
     * @since 1.1.0
     */
    public ColourRGB(Integer red, Integer green, Integer blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Construct the ColourRGB class
     * @since 1.1.0
     */
    public ColourRGB() {
    }

    /**
     * Get the red value of the colour
     * @return The red value of the colour
     * @since 1.1.0
     */
    public Integer getRed() {
        return this.red;
    }

    /**
     * Get the green value of the colour
     * @return The green value of the colour
     * @since 1.1.0
     */
    public Integer getGreen() {
        return this.green;
    }

    /**
     * Get the blue value of the colour
     * @return The blue value of the colour
     * @since 1.1.0
     */
    public Integer getBlue() {
        return this.blue;
    }

    /**
     * Set the red value of the colour
     * @param red The new red value of the colour
     * @since 1.1.0
     */
    public void setRed(Integer red) {
        this.red = red;
    }

    /**
     * Set the green value of the colour
     * @param green The new green value of the colour
     * @since 1.1.0
     */
    public void setGreen(Integer green) {
        this.green = green;
    }

    /**
     * Set the blue value of the colour
     * @param blue The new blue value of the colour
     * @since 1.1.0
     */
    public void setBlue(Integer blue) {
        this.blue = blue;
    }
}
