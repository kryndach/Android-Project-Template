package io.blackbricks.bricktemplate.ui.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import io.blackbricks.bricktemplate.App;
import io.blackbricks.bricktemplate.injection.component.ActivityComponent;
import io.blackbricks.bricktemplate.injection.component.DaggerActivityComponent;

/**
 * Created by yegorkryndach on 22/07/16.
 */
public abstract class BaseViewModelActivity<T extends ViewDataBinding, S extends ViewModel<T>>
        extends ViewModelActivity<T, S> {

    private ActivityComponent activityComponent;

    protected final ActivityComponent activityComponent() {
        if(activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .appComponent(App.getAppComponent())
                    .build();
        }

        return activityComponent;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activityComponent = null;
    }
}
