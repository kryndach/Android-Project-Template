package io.blackbricks.bricktemplate.service.net.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class CreateUserRequest {
    @SerializedName("username")
    String username;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;

    public CreateUserRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
