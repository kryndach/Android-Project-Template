package io.blackbricks.bricktemplate.service.net.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class LoginResponse {
    @SerializedName("session_key")
    String token;
    @SerializedName("userId")
    Integer userId;

    public String getToken() {
        return token;
    }

    public Integer getUserId() {
        return userId;
    }
}