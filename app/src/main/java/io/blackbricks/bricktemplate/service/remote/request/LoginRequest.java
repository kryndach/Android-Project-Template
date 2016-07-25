package io.blackbricks.bricktemplate.service.remote.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class LoginRequest {
    @SerializedName("username")
    String userName;
    @SerializedName("password")
    String password;

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}