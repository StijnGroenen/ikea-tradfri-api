package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.DeviceRequest;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

public class Plug extends Device {

    private PlugProperties properties;

    private PlugProperties newProperties;

    private CoapClient coapClient;

    public Plug(String name, Long creationDate, Integer instanceId, PlugProperties properties, CoapClient coapClient){
        super(name, creationDate, instanceId);
        this.properties = properties;
        this.newProperties = new PlugProperties();
        this.coapClient = coapClient;
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

    @Override
    public boolean applyUpdates() {
        boolean success = applyUpdate(newProperties);
        newProperties = new PlugProperties();
        return success;
    }

}
