package io.blackbricks.bricktemplate;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.orhanobut.hawk.Hawk;

import io.blackbricks.bricktemplate.injection.component.AppComponent;
import io.blackbricks.bricktemplate.injection.component.DaggerAppComponent;
import io.blackbricks.bricktemplate.service.db.core.DatabaseModule;
import io.blackbricks.bricktemplate.service.net.core.NetModule;
import io.blackbricks.bricktemplate.service.net.core.ApiConstants;

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
                .databaseModule(new DatabaseModule())
                .netModule(new NetModule(ApiConstants.API_BASE_URL, ApiConstants.APP_KEY))
                .build();

        Hawk.init(this).build();
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

    public static SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(instance);
    }
}
