package io.blackbricks.bricktemplate.injection.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import dagger.Component;
import io.blackbricks.bricktemplate.injection.module.AppModule;
import io.blackbricks.bricktemplate.injection.module.DatabaseModule;
import io.blackbricks.bricktemplate.injection.qualifier.AppContext;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@PerApplication
@Component(modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {
    @AppContext
    Context context();

    Resources resources();

    SharedPreferences sharedPreferences();
}