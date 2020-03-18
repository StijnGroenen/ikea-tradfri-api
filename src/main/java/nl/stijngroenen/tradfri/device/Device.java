package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

public class Device {

    private String name;

    private Long creationDate;

    private Integer instanceId;

    private DeviceProperties properties;

    protected CoapClient coapClient;

    private DeviceObserver observer;

    public Device(String name, Long creationDate, Integer instanceId, CoapClient coapClient){
        this.name = name;
        this.creationDate = creationDate;
        this.instanceId = instanceId;
        this.coapClient = coapClient;
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

    public boolean applyUpdates(){
        return false;
    }

    public boolean enableObserve() {
        if(observer == null) observer = new DeviceObserver(this, this.coapClient);
        return observer.start();
    }

    public boolean disableObserve() {
        if(observer == null) return false;
        return observer.stop();
    }

    public boolean isLight(){
        return this.getClass() == Light.class;
    }

    public Light toLight(){
        if(this.getClass() == Light.class){
            return (Light) this;
        }
        return null;
    }

    public boolean isPlug(){
        return this.getClass() == Plug.class;
    }

    public Plug toPlug(){
        if(this.getClass() == Plug.class){
            return (Plug) this;
        }
        return null;
    }

}
