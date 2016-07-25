package io.blackbricks.bricktemplate.ui.base;

import android.databinding.ViewDataBinding;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import io.blackbricks.bricktemplate.App;
import io.blackbricks.bricktemplate.injection.component.DaggerViewModelComponent;
import io.blackbricks.bricktemplate.injection.component.ViewModelComponent;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class BaseViewModel<T extends ViewDataBinding> extends ViewModel<T> {

    private ViewModelComponent viewModelComponent;

    protected final ViewModelComponent viewModelComponent() {
        if(viewModelComponent == null) {
            viewModelComponent = DaggerViewModelComponent.builder()
                    .appComponent(App.getAppComponent())
                    .build();
        }

        return viewModelComponent;
    }

    @Override
    public void onViewModelDestroyed() {
        super.onViewModelDestroyed();
        viewModelComponent = null;
    }
}
