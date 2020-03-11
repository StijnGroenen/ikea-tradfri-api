package nl.stijngroenen.tradfri.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.device.LightProperties;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceResponse {

    @JsonProperty(ApiCode.NAME)
    private String name;

    @JsonProperty(ApiCode.CREATION_DATE)
    private Long creationDate;

    @JsonProperty(ApiCode.INSTANCE_ID)
    private Integer instanceId;

    @JsonProperty(ApiCode.LIGHT)
    private LightProperties[] lightProperties;

    public String getName() {
        return this.name;
    }

    public Long getCreationDate() {
        return this.creationDate;
    }

    public Integer getInstanceId() {
        return this.instanceId;
    }

    public LightProperties[] getLightProperties() {
        return this.lightProperties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public void setLightProperties(LightProperties[] lightProperties) {
        this.lightProperties = lightProperties;
    }
}
