package io.blackbricks.bricktemplate.injection.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;
import io.blackbricks.bricktemplate.injection.qualifier.AppContext;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@Module
public class AppModule {

    private final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @PerApplication
    @AppContext
    Context provideAppContext() {
        return app;
    }

    @Provides
    @PerApplication
    Resources provideResources() {
        return app.getResources();
    }
}