package nl.stijngroenen.tradfri.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticateResponse {

    @JsonProperty(ApiCode.PRESHARED_KEY)
    private String presharedKey;

    @JsonProperty(ApiCode.GATEWAY_FIRMWARE_VERSION)
    private String gatewayFirmwareVersion;

    public String getPresharedKey() {
        return this.presharedKey;
    }

    public String getGatewayFirmwareVersion() {
        return this.gatewayFirmwareVersion;
    }

    public void setPresharedKey(String presharedKey) {
        this.presharedKey = presharedKey;
    }

    public void setGatewayFirmwareVersion(String gatewayFirmwareVersion) {
        this.gatewayFirmwareVersion = gatewayFirmwareVersion;
    }
}
