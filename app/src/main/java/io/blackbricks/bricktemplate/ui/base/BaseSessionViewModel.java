package io.blackbricks.bricktemplate.ui.base;

import android.databinding.ViewDataBinding;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import io.blackbricks.bricktemplate.App;
import io.blackbricks.bricktemplate.injection.component.SessionViewModelComponent;
import io.blackbricks.bricktemplate.service.session.SessionModule;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class BaseSessionViewModel<T extends ViewDataBinding> extends ViewModel<T> {

    private SessionViewModelComponent sessionViewModelComponent;

    protected final SessionViewModelComponent vmSessionComponent() {
        return sessionViewModelComponent;
    }

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        sessionViewModelComponent = App.getAppComponent()
                .sessionComponent(new SessionModule())
                .newSessionViewModelComponent();
    }

    @Override
    public void onViewModelDestroyed() {
        super.onViewModelDestroyed();
        sessionViewModelComponent = null;
    }
}
