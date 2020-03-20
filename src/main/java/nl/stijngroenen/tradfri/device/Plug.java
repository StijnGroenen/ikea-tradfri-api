package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.DeviceRequest;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

public class Plug extends Device {

    private PlugProperties properties;

    private PlugProperties newProperties;

    public Plug(String name, Long creationDate, Integer instanceId, PlugProperties properties, CoapClient coapClient){
        super(name, creationDate, instanceId, coapClient);
        this.properties = properties;
        this.newProperties = new PlugProperties();
    }

    @Override
    public PlugProperties getProperties(){
        return this.properties;
    }

    @Override
    public void setProperties(DeviceProperties properties){
        if(properties instanceof PlugProperties) this.properties = (PlugProperties) properties;
    }

    public Boolean getOn() {
        return properties.getOn();
    }

    public void updateOn(Boolean on) {
        newProperties.setOn(on);
    }

    public boolean setOn(Boolean on) {
        PlugProperties newProperties = new PlugProperties();
        newProperties.setOn(on);
        return applyUpdate(newProperties);
    }

    private boolean applyUpdate(PlugProperties newProperties) {
        DeviceRequest request = new DeviceRequest();
        request.setPlugProperties(new PlugProperties[]{newProperties});
        String response = coapClient.put(ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(getInstanceId())), request, String.class);
        return response != null;
    }

    public boolean applyUpdates() {
        boolean success = applyUpdate(newProperties);
        newProperties = new PlugProperties();
        return success;
    }

}
