package io.blackbricks.bricktemplate.service.net.core;

import java.io.IOException;

import javax.inject.Inject;

import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.service.session.SessionService;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by yegorkryndach on 28/07/16.
 */
@PerApplication
public class TokenAuthenticator implements Authenticator {

    private TokenRefresher tokenRefresher;

    @Inject
    public TokenAuthenticator(TokenRefresher tokenRefresher) {
        this.tokenRefresher = tokenRefresher;
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        String authToken = tokenRefresher.refreshToken();
        return response.request().newBuilder()
                .addHeader(ApiConstants.SESSION_KEY_HEADER, authToken)
                .build();
    }
}
