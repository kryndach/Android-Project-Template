package io.blackbricks.bricktemplate.service.net.core;

import java.io.IOException;

import javax.inject.Inject;

import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.service.net.AuthRemoteService;
import io.blackbricks.bricktemplate.service.net.request.LoginRequest;
import io.blackbricks.bricktemplate.service.session.SessionService;

/**
 * Created by yegorkryndach on 25/07/16.
 */
@PerApplication
public class TokenRefresher {

    private AuthRemoteService authRemoteService;
    private SessionService sessionService;

    @Inject
    public TokenRefresher(AuthRemoteService authRemoteService, SessionService sessionService) {
        this.authRemoteService = authRemoteService;
        this.sessionService = sessionService;
    }

    public String refreshToken() {
        LoginRequest loginRequest = new LoginRequest(sessionService.getUserName(), sessionService.getPassword());

        try {
            String newToken = authRemoteService.loginCall(loginRequest)
                    .execute()
                    .body()
                    .getToken();
            sessionService.setToken(newToken);
            return newToken;
        } catch (IOException e) {
            return null;
        }
    }

}
