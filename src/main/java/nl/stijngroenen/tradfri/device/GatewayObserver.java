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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.stijngroenen.tradfri.device.event.DeviceAddedEvent;
import nl.stijngroenen.tradfri.device.event.DeviceRemovedEvent;
import nl.stijngroenen.tradfri.device.event.EventHandler;
import nl.stijngroenen.tradfri.device.event.GatewayEvent;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class that observes an IKEA TRÅDFRI gateway to automagically detect changes
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class GatewayObserver extends Observer {

    /**
     * The IKEA TRÅDFRI gateway to observe
     */
    private Gateway gateway;

    /**
     * A cache of the devices registered to the IKEA TRÅDFRI gateway
     */
    private HashMap<Integer, Device> devices;

    /**
     * An object mapper used for mapping JSON responses from the IKEA TRÅDFRI gateway to Java classes
     */
    private ObjectMapper objectMapper;

    /**
     * Construct the GatewayObserver class
     * @param gateway The IKEA TRÅDFRI gateway to observe
     * @param coapClient A CoAP client that can be used to communicate with the device using the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public GatewayObserver(Gateway gateway, CoapClient coapClient) {
        super(ApiEndpoint.getUri(ApiEndpoint.DEVICES), coapClient);
        this.gateway = gateway;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Start observing the gateway to automagically detect changes
     * @return True if successfully started observing, false if not
     * @since 1.0.0
     */
    @Override
    public boolean start(){
        Device[] devices = gateway.getDevices();
        this.devices = new HashMap<>();
        for(Device device: devices){
            this.devices.put(device.getInstanceId(), device);
        }
        return super.start();
    }

    /**
     * Handles a new response from the CoAP client and calls the appropriate event handlers for the IKEA TRÅDFRI gateway
     * @param payload The payload of the response to the CoAP request
     * @since 1.0.0
     */
    @Override
    public void callEventHandlers(String payload) {
        try {
            int[] deviceIds = objectMapper.readValue(payload, int[].class);
            ArrayList<GatewayEvent> events = new ArrayList<>();
            ArrayList<EventHandler> called = new ArrayList<>();
            events.add(new GatewayEvent(gateway));
            ArrayList<Integer> added = new ArrayList<>();
            HashMap<Integer, Device> removed = (HashMap<Integer, Device>) devices.clone();
            for (int deviceId : deviceIds) {
                if (devices.containsKey(deviceId)) {
                    removed.remove(deviceId);
                } else {
                    added.add(deviceId);
                }
            }
            for (Integer addedDeviceId : added) {
                Device device = gateway.getDevice(addedDeviceId);
                devices.put(addedDeviceId, device);
                events.add(new DeviceAddedEvent(gateway, device));
            }
            for (Integer removedDeviceId : removed.keySet()) {
                Device device = devices.get(removedDeviceId);
                devices.remove(removedDeviceId);
                events.add(new DeviceRemovedEvent(gateway, device));
            }
            for (EventHandler eventHandler : gateway.getEventHandlers()) {
                for (GatewayEvent event : events) {
                    if (eventHandler.getEventType().isAssignableFrom(event.getClass()) && !called.contains(eventHandler)) {
                        eventHandler.handle(event);
                        called.add(eventHandler);
                    }
                }
            }
        } catch (JsonProcessingException ignored) {
        }
    }



}
