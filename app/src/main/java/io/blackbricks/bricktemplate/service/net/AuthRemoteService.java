package io.blackbricks.bricktemplate.service.net;

import io.blackbricks.bricktemplate.service.net.request.CreateUserRequest;
import io.blackbricks.bricktemplate.service.net.request.LoginRequest;
import io.blackbricks.bricktemplate.service.net.response.LoginResponse;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public interface AuthRemoteService {

    @POST("api/v1/users/create")
    Observable<ResponseBody> create(
            @Body CreateUserRequest createUserRequest
    );

    @POST("api/v1/login")
    Observable<LoginResponse> login(
            @Body LoginRequest loginRequest
    );

    @GET("api/v1/username/{username}")
    Observable<ResponseBody> checkUserName(
            @Path("username") String username
    );

    @GET("api/v1/email/{email}")
    Observable<ResponseBody> checkEmail(
            @Path("email") String email
    );

}
