package nl.stijngroenen.tradfri.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.device.LightProperties;
import nl.stijngroenen.tradfri.device.PlugProperties;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceRequest {

    @JsonProperty(ApiCode.LIGHT)
    private LightProperties[] lightProperties;

    @JsonProperty(ApiCode.PLUG)
    private PlugProperties[] plugProperties;

    public LightProperties[] getLightProperties() {
        return this.lightProperties;
    }

    public PlugProperties[] getPlugProperties() {
        return this.plugProperties;
    }

    public void setLightProperties(LightProperties[] lightProperties) {
        this.lightProperties = lightProperties;
    }

    public void setPlugProperties(PlugProperties[] plugProperties) {
        this.plugProperties = plugProperties;
    }
}
