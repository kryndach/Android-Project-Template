package io.blackbricks.bricktemplate.ui.main;

import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;
import io.blackbricks.bricktemplate.ui.base.BaseSessionViewModel;

public class MainViewModel extends BaseSessionViewModel<ActivityMainBinding> {


    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        vmSessionComponent().inject(this);
    }
}
