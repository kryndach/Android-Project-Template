package io.blackbricks.bricktemplate.injection.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import io.blackbricks.bricktemplate.injection.qualifier.ActivityContext;
import io.blackbricks.bricktemplate.injection.scope.PerActivity;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    @PerActivity
    FragmentManager provideFragmentManager() {
        return activity.getSupportFragmentManager();
    }
}