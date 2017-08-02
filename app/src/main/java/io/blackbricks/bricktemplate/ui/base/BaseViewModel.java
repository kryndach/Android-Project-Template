package io.blackbricks.bricktemplate.ui.base;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import io.blackbricks.bricktemplate.App;
import io.blackbricks.bricktemplate.injection.component.ViewModelComponent;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class BaseViewModel extends ViewModel {

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
