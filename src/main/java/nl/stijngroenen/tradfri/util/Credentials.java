package nl.stijngroenen.tradfri.util;

public class Credentials {

    private String identity;

    private String key;

    public Credentials(String identity, String key) {
        this.identity = identity;
        this.key = key;
    }

    public Credentials() {
    }

    public String getIdentity() {
        return this.identity;
    }

    public String getKey() {
        return this.key;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
