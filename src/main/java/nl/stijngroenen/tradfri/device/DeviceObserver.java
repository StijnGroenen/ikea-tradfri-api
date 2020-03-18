package nl.stijngroenen.tradfri.device;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.stijngroenen.tradfri.payload.DeviceResponse;
import nl.stijngroenen.tradfri.util.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

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

    @Override
    public void onLoad(CoapResponse coapResponse) {
        try {
            DeviceResponse response = objectMapper.readValue(coapResponse.getResponseText(), DeviceResponse.class);
            if(device.isLight() && response.getLightProperties() != null && response.getLightProperties().length > 0) device.setProperties(response.getLightProperties()[0]);
            if(device.isPlug() && response.getPlugProperties() != null && response.getPlugProperties().length > 0) device.setProperties(response.getPlugProperties()[0]);
        } catch (JsonProcessingException ignored) { }
    }

    @Override
    public void onError() {

    }

}
