package nl.stijngroenen.tradfri.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.stijngroenen.tradfri.util.ApiCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticateRequest {

    @JsonProperty(ApiCode.IDENTITY)
    private String identity;

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
