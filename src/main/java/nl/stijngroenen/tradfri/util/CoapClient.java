package nl.stijngroenen.tradfri.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.EndpointManager;
import org.eclipse.californium.scandium.DTLSConnector;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.pskstore.InMemoryPskStore;

import java.io.IOException;
import java.net.InetSocketAddress;

public class CoapClient {

    private ObjectMapper objectMapper;

    private Credentials credentials;

    private Endpoint dtlsEndpoint;

    public CoapClient(){
        objectMapper = new ObjectMapper();
    }

    public void setCredentials(Credentials credentials){
        this.credentials = credentials;
        try {
            updateDtlsConnector();
        } catch (IOException ignored) { }
    }

    private void updateDtlsConnector() throws IOException {
        if(dtlsEndpoint != null) dtlsEndpoint.destroy();
        DtlsConnectorConfig.Builder builder = new DtlsConnectorConfig.Builder();
        builder.setAddress(new InetSocketAddress(0));
        InMemoryPskStore pskStore = new InMemoryPskStore();
        pskStore.addKnownPeer(new InetSocketAddress(ApiEndpoint.getGatewayIp(), 5684),
                credentials.getIdentity(),
                credentials.getKey().getBytes());
        builder.setPskStore(pskStore);

        DTLSConnector dtlsconnector = new DTLSConnector(builder.build(), null);
        CoapEndpoint.Builder endpointBuilder = new CoapEndpoint.Builder();
        endpointBuilder.setConnector(dtlsconnector);

        dtlsEndpoint = endpointBuilder.build();
        dtlsEndpoint.start();
        EndpointManager.getEndpointManager().setDefaultEndpoint(dtlsEndpoint);
    }

    private <T> T request(Request request, String endpoint, Class<T> responseType) {
        try {
            request.setURI(endpoint);
            request.send();
            Response response = request.waitForResponse();
            if (response == null) return null;
            String responsePayload = response.getPayloadString();
            if (responseType == String.class) return (T) responsePayload;
            return objectMapper.readValue(responsePayload, responseType);
        } catch (InterruptedException | JsonProcessingException e) {
            return null;
        }
    }

    private <T> T requestWithPayload(Request request, String endpoint, Object payload, Class<T> responseType) {
        try {
            String requestPayload = objectMapper.writeValueAsString(payload);
            request.setPayload(requestPayload);
            request.getOptions().setContentFormat(MediaTypeRegistry.APPLICATION_JSON);
            return request(request, endpoint, responseType);
        } catch (IOException e) {
            return null;
        }
    }

    public CoapObserveRelation requestObserve(String endpoint, CoapHandler handler) {
        org.eclipse.californium.core.CoapClient client = new org.eclipse.californium.core.CoapClient();
        Request request = Request.newGet();
        request.setURI(endpoint);
        request.setObserve();
        CoapObserveRelation relation = client.observe(request, handler);
        return relation;
    }

    public <T> T get(String endpoint, Class<T> responseType) {
        Request request = Request.newGet();
        return request(request, endpoint, responseType);
    }

    public <T> T post(String endpoint, Object payload, Class<T> responseType) {
        Request request = Request.newPost();
        return requestWithPayload(request, endpoint, payload, responseType);
    }

    public <T> T put(String endpoint, Object payload, Class<T> responseType) {
        Request request = Request.newPut();
        return requestWithPayload(request, endpoint, payload, responseType);
    }

    public Credentials getCredentials() {
        return this.credentials;
    }
}
