package io.blackbricks.bricktemplate.service.net.core;

import dagger.Module;
import dagger.Provides;
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
    //@PerSession
    Retrofit provideRetrofit(SessionService userSessionService) {
        String authToken = userSessionService.getToken();
        return getRetrofit(authToken);
    }

    @Provides
    TokenInterceptor provideAuthInterseptor(SessionService userSessionService) {
        String authToken = userSessionService.getToken();
        return new TokenInterceptor(appKey, authToken);
    }

    private Retrofit getRetrofit(String authToken) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .authenticator()
                .addNetworkInterceptor(new TokenInterceptor(appKey, authToken))
                .build();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @PerApplication
    AuthRemoteService provideAuthRemoteService(){
        Retrofit retrofit = getRetrofit(null);
        return retrofit.create(AuthRemoteService.class);
    }

    @Provides
    //@PerSession
    SampleRemoteService provideSampleRemoteService(Retrofit retrofit){
        return retrofit.create(SampleRemoteService.class);
    }

}
