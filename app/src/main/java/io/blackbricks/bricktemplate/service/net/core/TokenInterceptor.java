package io.blackbricks.bricktemplate.service.net.core;

import java.io.IOException;

import io.blackbricks.bricktemplate.service.session.SessionService;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class TokenInterceptor implements Interceptor {

    private SessionService sessionService;

    public TokenInterceptor(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        String authToken = sessionService.getToken();
        if(authToken == null) {
            return chain.proceed(original);
        }

        Request.Builder requestBuilder = original.newBuilder()
                .header(ApiConstants.SESSION_KEY_HEADER, authToken)
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
