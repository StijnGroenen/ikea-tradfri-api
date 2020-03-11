package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.AuthenticateRequest;
import nl.stijngroenen.tradfri.payload.AuthenticateResponse;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;
import nl.stijngroenen.tradfri.util.Credentials;
import org.apache.commons.lang3.RandomStringUtils;

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

}
