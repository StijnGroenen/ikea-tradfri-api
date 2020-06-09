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
 * The class that contains XY values that make up a colour
 * @author Stijn Groenen
 * @version 1.1.0
 */
public class ColourXY {

    /**
     * The X value of the colour
     */
    private Integer X;

    /**
     * The Y value of the colour
     */
    private Integer Y;

    /**
     * Construct the ColourXY class
     * @param X The X value of the colour
     * @param Y The Y value of the colour
     * @since 1.1.0
     */
    public ColourXY(Integer X, Integer Y) {
        this.X = X;
        this.Y = Y;
    }

    /**
     * Construct the ColourXY class
     * @since 1.1.0
     */
    public ColourXY() {
    }

    /**
     * Get the X value of the colour
     * @return The X value of the colour
     * @since 1.1.0
     */
    public Integer getX() {
        return this.X;
    }

    /**
     * Get the Y value of the colour
     * @return The Y value of the colour
     * @since 1.1.0
     */
    public Integer getY() {
        return this.Y;
    }

    /**
     * Set the X value of the colour
     * @param X The new X value of the colour
     * @since 1.1.0
     */
    public void setX(Integer X) {
        this.X = X;
    }

    /**
     * Set the Y value of the colour
     * @param Y The new Y value of the colour
     * @since 1.1.0
     */
    public void setY(Integer Y) {
        this.Y = Y;
    }
}
