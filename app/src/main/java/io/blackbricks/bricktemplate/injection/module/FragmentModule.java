package io.blackbricks.bricktemplate.injection.module;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import io.blackbricks.bricktemplate.injection.qualifier.ActivityContext;
import io.blackbricks.bricktemplate.injection.scope.PerFragment;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@Module
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    @ActivityContext
    Context provideAppContext() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    FragmentManager provideFragmentManager() { return mFragment.getFragmentManager(); }

}
