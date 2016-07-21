package io.blackbricks.bricktemplate.injection.module;

import dagger.Module;

/**
 * Created by yegorkryndach on 21/07/16.
 */
@Module
public class NetModule {
    private String mBaseUrl;
    private String mAppKey;

    public NetModule(String baseUrl, String appKey) {
        this.mBaseUrl = baseUrl;
        this.mAppKey = appKey;
    }


}
