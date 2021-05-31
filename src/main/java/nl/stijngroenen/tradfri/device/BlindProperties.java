package nl.stijngroenen.tradfri.device;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlindProperties extends DeviceProperties {

    /**
     * The position of the blind represented in a float value.
     */
    @JsonProperty(ApiCode.POSITION)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT)
    private Float position;

    public Float getPosition() {
        return position;
    }

    public void setPosition(Float position) {
        this.position = position;
    }
}
