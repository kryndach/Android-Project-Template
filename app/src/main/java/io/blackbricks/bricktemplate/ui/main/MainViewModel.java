package io.blackbricks.bricktemplate.ui.main;

import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;
import io.blackbricks.bricktemplate.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel<ActivityMainBinding> {


    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        viewModelComponent().inject(this);
    }
}
