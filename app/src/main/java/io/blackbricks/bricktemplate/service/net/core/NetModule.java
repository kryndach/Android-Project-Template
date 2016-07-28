package io.blackbricks.bricktemplate.service.net.core;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import io.blackbricks.bricktemplate.injection.qualifier.AuthToken;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.service.net.AuthRemoteService;
import io.blackbricks.bricktemplate.service.net.SampleRemoteService;
import io.blackbricks.bricktemplate.service.session.SessionService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yegorkryndach on 21/07/16.
 */
@Module
public class NetModule {
    private String baseUrl;
    private String appKey;

    public NetModule(String baseUrl, String appKey) {
        this.baseUrl = baseUrl;
        this.appKey = appKey;
    }

    @Provides
    @PerApplication
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new AppKeyInterceptor(appKey))
                .build();
    }

    @Provides
    @PerApplication
    @AuthToken
    OkHttpClient provideOkHttpClientAuth(TokenInterceptor tokenInterceptor,
                                         TokenAuthenticator tokenAuthenticator) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new AppKeyInterceptor(appKey))
                .addNetworkInterceptor(tokenInterceptor)
                .authenticator(tokenAuthenticator)
                .build();
    }

    private Retrofit getRetrofit(@NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @PerApplication
    AuthRemoteService provideAuthRemoteService(OkHttpClient okHttpClient) {
        Retrofit retrofit = getRetrofit(okHttpClient);
        return retrofit.create(AuthRemoteService.class);
    }

    @Provides
    @PerApplication
    SampleRemoteService provideSampleRemoteService(@AuthToken OkHttpClient okHttpClient) {
        Retrofit retrofit = getRetrofit(okHttpClient);
        return retrofit.create(SampleRemoteService.class);
    }

}
