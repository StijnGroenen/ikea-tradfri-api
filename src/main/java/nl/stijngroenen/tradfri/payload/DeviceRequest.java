package nl.stijngroenen.tradfri.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.device.LightProperties;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceRequest {

    @JsonProperty(ApiCode.LIGHT)
    private LightProperties[] lightProperties;

    public LightProperties[] getLightProperties() {
        return this.lightProperties;
    }

    public void setLightProperties(LightProperties[] lightProperties) {
        this.lightProperties = lightProperties;
    }
}
