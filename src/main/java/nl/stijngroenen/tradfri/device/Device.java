package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.device.event.DeviceEventHandler;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

import java.util.ArrayList;
import java.util.List;

public class Device {

    private String name;

    private Long creationDate;

    private Integer instanceId;

    private DeviceProperties properties;

    protected CoapClient coapClient;

    private DeviceObserver observer;

    private List<DeviceEventHandler> eventHandlers;

    public Device(String name, Long creationDate, Integer instanceId, CoapClient coapClient){
        this.name = name;
        this.creationDate = creationDate;
        this.instanceId = instanceId;
        this.coapClient = coapClient;
        this.eventHandlers = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Long getCreationDate() {
        return this.creationDate;
    }

    public Integer getInstanceId() {
        return this.instanceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public DeviceProperties getProperties(){
        return this.properties;
    }

    public void setProperties(DeviceProperties properties){
        this.properties = properties;
    }

    public String getEndpoint(){
        return ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(getInstanceId()));
    }


    public boolean enableObserve() {
        if(observer == null) observer = new DeviceObserver(this, this.coapClient);
        return observer.start();
    }

    public boolean disableObserve() {
        if(observer == null) return false;
        return observer.stop();
    }

    public List<DeviceEventHandler> getEventHandlers(){
        return eventHandlers;
    }

    public void addEventHandler(DeviceEventHandler eventHandler){
        this.eventHandlers.add(eventHandler);
    }

    public void removeEventHandler(DeviceEventHandler eventHandler){
        this.eventHandlers.remove(eventHandler);
    }

    public boolean isLight(){
        return this instanceof Light;
    }

    public Light toLight(){
        if(isLight()) return (Light) this;
        return null;
    }

    public boolean isPlug(){
        return this instanceof Plug;
    }

    public Plug toPlug(){
        if(isPlug()) return (Plug) this;
        return null;
    }

}
