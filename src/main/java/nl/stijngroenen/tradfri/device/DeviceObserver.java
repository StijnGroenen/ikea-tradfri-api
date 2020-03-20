package nl.stijngroenen.tradfri.device;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.stijngroenen.tradfri.device.event.*;
import nl.stijngroenen.tradfri.payload.DeviceResponse;
import nl.stijngroenen.tradfri.util.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

import java.util.ArrayList;

public class DeviceObserver implements CoapHandler {

    private Device device;

    private CoapClient coapClient;

    private CoapObserveRelation coapObserveRelation;

    private ObjectMapper objectMapper;

    public DeviceObserver(Device device, CoapClient coapClient) {
        this.device = device;
        this.coapClient = coapClient;
        this.objectMapper = new ObjectMapper();
    }

    public boolean start(){
        if(coapObserveRelation == null || coapObserveRelation.isCanceled()){
            coapObserveRelation = coapClient.requestObserve(device.getEndpoint(), this);
            return true;
        }
        return false;
    }

    public boolean stop(){
        if(coapObserveRelation != null && !coapObserveRelation.isCanceled()){
            coapObserveRelation.proactiveCancel();
            return true;
        }
        return false;
    }

    private boolean checkChanges(Object oldValue, Object newValue){
        return ((oldValue == null && newValue != null) || (newValue == null && oldValue != null) || (oldValue != null && !oldValue.equals(newValue)));
    }

    @Override
    public void onLoad(CoapResponse coapResponse) {
        try {
            DeviceResponse response = objectMapper.readValue(coapResponse.getResponseText(), DeviceResponse.class);
            ArrayList<DeviceEvent> events = new ArrayList<>();
            ArrayList<DeviceEventHandler> called = new ArrayList<>();
            if(device.isLight()){
                LightProperties oldProperties = (LightProperties) device.getProperties();
                if(response.getLightProperties() != null && response.getLightProperties().length > 0) device.setProperties(response.getLightProperties()[0]);
                LightProperties newProperties = (LightProperties) device.getProperties();
                events.add(new LightEvent(device.toLight()));
                ArrayList<DeviceEvent> changeEvents = new ArrayList<>();
                if(checkChanges(oldProperties.getOn(), newProperties.getOn())) changeEvents.add(new LightChangeOnEvent(device.toLight(), oldProperties, newProperties));
                if(checkChanges(oldProperties.getBrightness(), newProperties.getBrightness())) changeEvents.add(new LightChangeBrightnessEvent(device.toLight(), oldProperties, newProperties));
                if(checkChanges(oldProperties.getColourHex(), newProperties.getColourHex())) changeEvents.add(new LightChangeColourHexEvent(device.toLight(), oldProperties, newProperties));
                if(checkChanges(oldProperties.getHue(), newProperties.getHue())) changeEvents.add(new LightChangeHueEvent(device.toLight(), oldProperties, newProperties));
                if(checkChanges(oldProperties.getSaturation(), newProperties.getSaturation())) changeEvents.add(new LightChangeSaturationEvent(device.toLight(), oldProperties, newProperties));
                if(checkChanges(oldProperties.getColourX(), newProperties.getColourX())) changeEvents.add(new LightChangeColourXEvent(device.toLight(), oldProperties, newProperties));
                if(checkChanges(oldProperties.getColourY(), newProperties.getColourY())) changeEvents.add(new LightChangeColourYEvent(device.toLight(), oldProperties, newProperties));
                if(checkChanges(oldProperties.getColourTemperature(), newProperties.getColourTemperature())) changeEvents.add(new LightChangeColourTemperatureEvent(device.toLight(), oldProperties, newProperties));
                if(changeEvents.size() > 0){
                    events.add(new LightChangeEvent(device.toLight(), oldProperties, newProperties));
                    events.addAll(changeEvents);
                }
            }else if(device.isPlug()){
                PlugProperties oldProperties = (PlugProperties) device.getProperties();
                if(response.getPlugProperties() != null && response.getPlugProperties().length > 0) device.setProperties(response.getPlugProperties()[0]);
                PlugProperties newProperties = (PlugProperties) device.getProperties();
                events.add(new PlugEvent(device.toPlug()));
                if(checkChanges(oldProperties.getOn(), newProperties.getOn())){
                    events.add(new PlugChangeEvent(device.toPlug(), oldProperties, newProperties));
                    events.add(new PlugChangeOnEvent(device.toPlug(), oldProperties, newProperties));
                }
            }
            for(DeviceEventHandler eventHandler: device.getEventHandlers()){
                for(DeviceEvent event: events){
                    if(eventHandler.getEventType().isAssignableFrom(event.getClass()) && !called.contains(eventHandler)){
                        eventHandler.handle(event);
                        called.add(eventHandler);
                    }
                }
            }
        } catch (JsonProcessingException ignored) { }
    }

    @Override
    public void onError() {

    }

}
