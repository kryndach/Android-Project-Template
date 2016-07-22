package io.blackbricks.bricktemplate;

import android.app.Application;
import android.content.res.Resources;

import io.blackbricks.bricktemplate.injection.component.AppComponent;
import io.blackbricks.bricktemplate.injection.component.DaggerAppComponent;
import io.blackbricks.bricktemplate.injection.module.AppModule;

/**
 * Created by yegorkryndach on 22/07/16.
 */
public class App extends Application {
    private static App instance = null;
    private static AppComponent appComponent = null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static Resources getRes() {
        return instance.getResources();
    }
}
