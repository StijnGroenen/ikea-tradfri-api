package nl.stijngroenen.tradfri.device;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlugProperties extends DeviceProperties {

    @JsonProperty(ApiCode.ON_OFF)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Boolean on;

    public Boolean getOn() {
        return this.on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }
}
