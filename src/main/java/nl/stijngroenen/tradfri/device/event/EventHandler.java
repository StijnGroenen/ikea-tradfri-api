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

import java.lang.reflect.ParameterizedType;

/**
 * The class that handles events for IKEA TRÅDFRI devices
 * @author Stijn Groenen
 * @version 1.0.0
 */
public abstract class EventHandler<T extends Event> {

    /**
     * Construct the EventHandler class
     * @since 1.0.0
     */
    public EventHandler(){
    }

    /**
     * Handle the event
     * @param event The event that occurred
     * @since 1.0.0
     */
    public abstract void handle(T event);

    /**
     * Get the class of the event that this event handler handles
     * @return The class of the event that this event handler handles
     */
    public Class<T> getEventType(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
