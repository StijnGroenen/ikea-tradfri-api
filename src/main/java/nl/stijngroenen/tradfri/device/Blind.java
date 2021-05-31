package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.DeviceRequest;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

public class Blind extends Device{
    /**
     * Construct the Device class
     *
     * @param name         The name of the device
     * @param creationDate The creation date of the device
     * @param instanceId   The instance id of the device
     * @param deviceInfo   The information of the device
     * @param coapClient   A CoAP client that can be used to communicate with the device using the IKEA TRÅDFRI gateway

     */
    public Blind(String name, Long creationDate, Integer instanceId, DeviceInfo deviceInfo, CoapClient coapClient) {
        super(name, creationDate, instanceId, deviceInfo, coapClient);
    }

    /**
     * Set the position of Blind
     * @param position The new position of Blind
     * @return True if successfully updated the position, false if not
     * @since 1.3.0
     */
    public boolean setPosition(Float position) {
        BlindProperties newProperties = new BlindProperties();
        newProperties.setPosition(position);
        return applyUpdate(newProperties);
    }

    /**
     * Apply updates to the plug
     * @param newProperties The new properties to apply to the plug
     * @return True if successfully updated the plug, false if not
     * @since 1.3.0
     */
    private boolean applyUpdate(BlindProperties newProperties) {
        DeviceRequest request = new DeviceRequest();
        request.setBlindProperties(new BlindProperties[]{newProperties});
        String response = coapClient.put(ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(getInstanceId())), request, String.class);
        return response != null;
    }

}
