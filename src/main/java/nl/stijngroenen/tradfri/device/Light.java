package nl.stijngroenen.tradfri.device;

import nl.stijngroenen.tradfri.payload.DeviceRequest;
import nl.stijngroenen.tradfri.util.ApiEndpoint;
import nl.stijngroenen.tradfri.util.CoapClient;

public class Light extends Device {

    private LightProperties properties;

    private LightProperties newProperties;

    public Light(String name, Long creationDate, Integer instanceId, LightProperties properties, CoapClient coapClient){
        super(name, creationDate, instanceId, coapClient);
        this.properties = properties;
        this.newProperties = new LightProperties();
    }

    @Override
    public LightProperties getProperties(){
        return this.properties;
    }

    @Override
    public void setProperties(DeviceProperties properties){
        if(properties instanceof LightProperties) this.properties = (LightProperties) properties;
    }

    public Boolean getOn() {
        return properties.getOn();
    }

    public Integer getBrightness() {
        return properties.getBrightness();
    }

    public String getColourHex() {
        return properties.getColourHex();
    }

    public Integer getHue() {
        return properties.getHue();
    }

    public Integer getSaturation() {
        return properties.getSaturation();
    }

    public Integer getColourX() {
        return properties.getColourX();
    }

    public Integer getColourY() {
        return properties.getColourY();
    }

    public Integer getColourTemperature() {
        return properties.getColourTemperature();
    }

    public void updateOn(Boolean on) {
        newProperties.setOn(on);
    }

    public void updateBrightness(Integer brightness) {
        newProperties.setBrightness(brightness);
    }

    public void updateColourHex(String colourHex) {
        newProperties.setColourHex(colourHex);
        newProperties.setHue(null);
        newProperties.setSaturation(null);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
        newProperties.setColourTemperature(null);
    }

    public void updateHue(Integer hue) {
        newProperties.setHue(hue);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
        newProperties.setColourHex(null);
        newProperties.setColourTemperature(null);
    }

    public void updateSaturation(Integer saturation) {
        newProperties.setSaturation(saturation);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
        newProperties.setColourHex(null);
        newProperties.setColourTemperature(null);
    }

    public void updateColourXY(Integer colourX, Integer colourY) {
        newProperties.setColourX(colourX);
        newProperties.setColourY(colourY);
        newProperties.setColourHex(null);
        newProperties.setHue(null);
        newProperties.setSaturation(null);
        newProperties.setColourTemperature(null);
    }

    public void updateColourTemperature(Integer colourTemperature) {
        newProperties.setColourTemperature(colourTemperature);
        newProperties.setColourHex(null);
        newProperties.setHue(null);
        newProperties.setSaturation(null);
        newProperties.setColourX(null);
        newProperties.setColourY(null);
    }

    public void updateTransitionTime(Integer transitionTime){
        newProperties.setTransitionTime(transitionTime);
    }

    public boolean setOn(Boolean on, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setOn(on);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    public boolean setOn(Boolean on){
        return setOn(on, null);
    }

    public boolean setBrightness(Integer brightness, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setBrightness(brightness);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    public boolean setBrightness(Integer brightness){
        return setBrightness(brightness, null);
    }

    public boolean setColourHex(String colourHex, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setColourHex(colourHex);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    public boolean setColourHex(String colourHex){
        return setColourHex(colourHex, null);
    }

    public boolean setHue(Integer hue, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setHue(hue);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    public boolean setHue(Integer hue){
        return setHue(hue, null);
    }

    public boolean setSaturation(Integer saturation, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setSaturation(saturation);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    public boolean setSaturation(Integer saturation){
        return setSaturation(saturation, null);
    }

    public boolean setColourXY(Integer colourX, Integer colourY, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setColourX(colourX);
        newProperties.setColourY(colourY);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    public boolean setColourXY(Integer colourX, Integer colourY){
        return setColourXY(colourX, colourY, null);
    }

    public boolean setColourTemperature(Integer colourTemperature, Integer transitionTime) {
        LightProperties newProperties = new LightProperties();
        newProperties.setColourTemperature(colourTemperature);
        newProperties.setTransitionTime(transitionTime);
        return applyUpdate(newProperties);
    }

    public boolean setColourTemperature(Integer colourTemperature){
        return setColourTemperature(colourTemperature, null);
    }

    private boolean applyUpdate(LightProperties newProperties) {
        DeviceRequest request = new DeviceRequest();
        request.setLightProperties(new LightProperties[]{newProperties});
        String response = coapClient.put(ApiEndpoint.getUri(ApiEndpoint.DEVICES, String.valueOf(getInstanceId())), request, String.class);
        return response != null;
    }

    public boolean applyUpdates() {
        boolean success = applyUpdate(newProperties);
        newProperties = new LightProperties();
        return success;
    }

    public boolean applyUpdates(Integer transitionTime) {
        newProperties.setTransitionTime(transitionTime);
        return applyUpdates();
    }

}
