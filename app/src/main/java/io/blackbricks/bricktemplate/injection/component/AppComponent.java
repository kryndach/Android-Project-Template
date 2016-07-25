package io.blackbricks.bricktemplate.injection.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import dagger.Component;
import io.blackbricks.bricktemplate.AppModule;
import io.blackbricks.bricktemplate.service.local.DatabaseModule;
import io.blackbricks.bricktemplate.service.local.SampleLocalService;
import io.blackbricks.bricktemplate.service.remote.NetModule;
import io.blackbricks.bricktemplate.injection.qualifier.AppContext;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.service.remote.service.SampleRemoteService;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@PerApplication
@Component(modules = {AppModule.class, DatabaseModule.class, NetModule.class})
public interface AppComponent {
    // App
    @AppContext
    Context context();

    Resources resources();

    SharedPreferences sharedPreferences();

    // Local data
    SampleLocalService sampleLocalService();

    // Remote data
    SampleRemoteService sampleRemoteService();
}