package io.blackbricks.bricktemplate.service.net.core;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class AppKeyInterceptor implements Interceptor {

    private String mAppKey;

    public AppKeyInterceptor(String mAppKey) {
        this.mAppKey = mAppKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header(ApiConstants.APP_KEY_HEADER, mAppKey)
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
