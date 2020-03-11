package nl.stijngroenen.tradfri.device;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LightProperties extends DeviceProperties{

    @JsonProperty(ApiCode.ON_OFF)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Boolean on;

    @JsonProperty(ApiCode.BRIGHTNESS)
    private Integer brightness;

    @JsonProperty(ApiCode.COLOUR_HEX)
    private String colourHex;

    @JsonProperty(ApiCode.HUE)
    private Integer hue;

    @JsonProperty(ApiCode.SATURATION)
    private Integer saturation;

    @JsonProperty(ApiCode.COLOUR_X)
    private Integer colourX;

    @JsonProperty(ApiCode.COLOUR_Y)
    private Integer colourY;

    @JsonProperty(ApiCode.COLOUR_TEMPERATURE)
    private Integer colourTemperature;

    @JsonProperty(ApiCode.TRANSITION_TIME)
    private Integer transitionTime;

    public Boolean getOn() {
        return this.on;
    }

    public Integer getBrightness() {
        return this.brightness;
    }

    public String getColourHex() {
        return this.colourHex;
    }

    public Integer getHue() {
        return this.hue;
    }

    public Integer getSaturation() {
        return this.saturation;
    }

    public Integer getColourX() {
        return this.colourX;
    }

    public Integer getColourY() {
        return this.colourY;
    }

    public Integer getColourTemperature() {
        return this.colourTemperature;
    }

    public Integer getTransitionTime() {
        return this.transitionTime;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public void setColourHex(String colourHex) {
        this.colourHex = colourHex;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    public void setColourX(Integer colourX) {
        this.colourX = colourX;
    }

    public void setColourY(Integer colourY) {
        this.colourY = colourY;
    }

    public void setColourTemperature(Integer colourTemperature) {
        this.colourTemperature = colourTemperature;
    }

    public void setTransitionTime(Integer transitionTime) {
        this.transitionTime = transitionTime;
    }
}
