package io.blackbricks.bricktemplate.ui.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;

/**
 * Created by yegorkryndach on 22/07/16.
 */
public abstract class BaseViewModelActivity<T extends ViewDataBinding, S extends ViewModel<T>>
        extends ViewModelActivity<T, S> {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
