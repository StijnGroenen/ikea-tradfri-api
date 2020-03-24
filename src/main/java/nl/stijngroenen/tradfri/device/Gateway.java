package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.AuthenticateRequest;
import nl.stijngroenen.tradfri.payload.AuthenticateResponse;
import nl.stijngroenen.tradfri.payload.DeviceResponse;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;
import nl.stijngroenen.tradfri.util.Credentials;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

/**
 * The class that is used to communicate with the IKEA TRÅDFRI gateway
 * @author Stijn Groenen
 * @version 1.0.0
 */
public class Gateway {

    /**
     * A CoAP client that can be used to communicate with the IKEA TRÅDFRI gateway
     */
    private CoapClient coapClient;

    /**
     * Construct the Gateway class
     * @param ip The IP-address of the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Gateway(String ip) {
        ApiEndpoint.setGatewayIp(ip);
        coapClient = new CoapClient();
    }

    /**
     * Connect and authenticate to the IKEA TRÅDFRI gateway using a security code
     * @param securityCode The security code of the IKEA TRÅDFRI gateway
     * @return Credentials that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Credentials connect(String securityCode) {
        String identity = RandomStringUtils.randomAlphanumeric(16);
        AuthenticateRequest request = new AuthenticateRequest();
        request.setIdentity(identity);
        setCredentials("Client_identity", securityCode);
        AuthenticateResponse response = coapClient.post(ApiEndpoint.getUri(ApiEndpoint.AUTHENTICATE), request, AuthenticateResponse.class);
        Credentials credentials = new Credentials(identity, response.getPresharedKey());
        setCredentials(credentials);
        return credentials;
    }

    /**
     * Connect and authenticate to the IKEA TRÅDFRI gateway using credentials
     * @param credentials The credentials that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @return Credentials that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Credentials connect(Credentials credentials){
        setCredentials(credentials);
        return credentials;
    }

    /**
     * Change the credentials used to communicate with the IKEA TRÅDFRI gateway
     * @param credentials The new credentials that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public void setCredentials(Credentials credentials){
        coapClient.setCredentials(credentials);
    }

    /**
     * Change the credentials used to communicate with the IKEA TRÅDFRI gateway
     * @param identity The new identity that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @param key The new key that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public void setCredentials(String identity, String key){
        Credentials credentials = new Credentials(identity, key);
        setCredentials(credentials);
    }

    /**
     * Get the credentials used to communicate with the IKEA TRÅDFRI gateway
     * @return The credentials that can be used to authenticate to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Credentials getCredentials(){
        return coapClient.getCredentials();
    }

    /**
     * Get the ids of the devices registered to the IKEA TRÅDFRI gateway
     * @return An array of the ids of the devices registered to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public int[] getDeviceIds(){
        return coapClient.get(ApiEndpoint.getUri(ApiEndpoint.DEVICES), int[].class);
    }

    /**
     * Get the a device registered to the IKEA TRÅDFRI gateway
     * @param id The id of a device registered to the IKEA TRÅDFRI gateway
     * @return The device with the provided id
     * @since 1.0.0
     */
    public Device getDevice(int id){
        DeviceResponse response = coapClient.get(ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(id)), DeviceResponse.class);
        if(response.getLightProperties() != null && response.getLightProperties().length > 0){
            return new Light(response.getName(), response.getCreationDate(), response.getInstanceId(), response.getLightProperties()[0], coapClient);
        }else if(response.getPlugProperties() != null && response.getPlugProperties().length > 0){
            return new Plug(response.getName(), response.getCreationDate(), response.getInstanceId(), response.getPlugProperties()[0], coapClient);
        }else{
            return new Device(response.getName(), response.getCreationDate(), response.getInstanceId(), coapClient);
        }
    }

    /**
     * Get the devices registered to the IKEA TRÅDFRI gateway
     * @return An array of the devices registered to the IKEA TRÅDFRI gateway
     * @since 1.0.0
     */
    public Device[] getDevices(){
        ArrayList<Device> deviceList = new ArrayList<>();
        int[] deviceIds = getDeviceIds();
        for(int deviceId: deviceIds){
            Device device = getDevice(deviceId);
            deviceList.add(device);
        }
        Device[] devices = new Device[deviceList.size()];
        deviceList.toArray(devices);
        return devices;
    }

}
