package nl.stijngroenen.tradfri.util;

public class ApiEndpoint {

    private static String gatewayIp;

    public static void setGatewayIp(String ip){
        gatewayIp = ip;
    }

    public static String getBaseUrl(){
        return "coaps://"+gatewayIp+":5684";
    }

    public static String getUri(String... endpoint){
        return getBaseUrl()+"/"+String.join("/", endpoint);
    }

    // Gateway
    public static final String AUTHENTICATE = "15011/9063";
    public static final String GATEWAY_REBOOT = "15011/9030";
    public static final String GATEWAY_RESET = "15011/9031";
    public static final String GATEWAY_UPDATE_FIRMWARE = "15011/9034";
    public static final String GATEWAY_DETAILS = "15011/15012";

    // Global
    public static final String DEVICES = "15001";
    public static final String GROUPS = "15004";
    public static final String SCENES = "15005";
    public static final String NOTIFICATIONS = "15006";
    public static final String SMART_TASKS = "15010";

    public static String getGatewayIp() {
        return ApiEndpoint.gatewayIp;
    }
}
