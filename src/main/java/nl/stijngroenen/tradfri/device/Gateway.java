package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.AuthenticateRequest;
import nl.stijngroenen.tradfri.payload.AuthenticateResponse;
import nl.stijngroenen.tradfri.payload.DeviceResponse;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;
import nl.stijngroenen.tradfri.util.Credentials;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class Gateway {

    private CoapClient coapClient;

    public Gateway(String ip) {
        ApiEndpoint.setGatewayIp(ip);
        coapClient = new CoapClient();
    }

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

    public Credentials connect(Credentials credentials){
        setCredentials(credentials);
        return credentials;
    }

    public void setCredentials(Credentials credentials){
        coapClient.setCredentials(credentials);
    }

    public void setCredentials(String identity, String key){
        Credentials credentials = new Credentials(identity, key);
        setCredentials(credentials);
    }

    public Credentials getCredentials(){
        return coapClient.getCredentials();
    }

    public int[] getDeviceIds(){
        return coapClient.get(ApiEndpoint.getUri(ApiEndpoint.DEVICES), int[].class);
    }

    public Device getDevice(int id){
        DeviceResponse response = coapClient.get(ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(id)), DeviceResponse.class);
        if(response.getLightProperties() != null && response.getLightProperties().length > 0){
            return new Light(response.getName(), response.getCreationDate(), response.getInstanceId(), response.getLightProperties()[0], coapClient);
        }else{
            return new Device(response.getName(), response.getCreationDate(), response.getInstanceId()) {
                @Override
                public boolean applyUpdates() {
                    return false;
                }
            };
        }
    }

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
