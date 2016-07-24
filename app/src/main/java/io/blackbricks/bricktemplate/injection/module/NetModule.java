package io.blackbricks.bricktemplate.injection.module;

import dagger.Module;

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


}
