package io.blackbricks.bricktemplate.ui.base;

import android.databinding.ViewDataBinding;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import io.blackbricks.bricktemplate.App;
import io.blackbricks.bricktemplate.injection.component.ViewModelComponent;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class BaseViewModel<T extends ViewDataBinding> extends ViewModel<T> {

    private ViewModelComponent viewModelComponent;

    protected final ViewModelComponent viewModelComponent() {
        return viewModelComponent;
    }

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        viewModelComponent = App.getAppComponent().viewModelComponent();
    }

    @Override
    public void onViewModelDestroyed() {
        super.onViewModelDestroyed();
        viewModelComponent = null;
    }
}
