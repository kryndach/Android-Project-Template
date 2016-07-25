package io.blackbricks.bricktemplate.service.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.blackbricks.bricktemplate.injection.qualifier.AuthToken;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.service.remote.service.AuthRemoteService;
import io.blackbricks.bricktemplate.service.remote.service.SampleRemoteService;
import io.blackbricks.bricktemplate.service.session.UserSessionService;
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
    Retrofit provideRetrofit(UserSessionService userSessionService) {
        String authToken = userSessionService.getToken();
        return getRetrofit(authToken);
    }

    private Retrofit getRetrofit(String authToken) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new AuthInterceptor(appKey, authToken))
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
    SampleRemoteService provideSampleRemoteService(Retrofit retrofit){
        return retrofit.create(SampleRemoteService.class);
    }

}
