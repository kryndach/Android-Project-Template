package io.blackbricks.bricktemplate.ui.main;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import io.blackbricks.bricktemplate.BR;
import io.blackbricks.bricktemplate.R;
import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;
import io.blackbricks.bricktemplate.ui.base.BaseViewModelActivity;

public class MainActivity extends BaseViewModelActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public ViewModelBindingConfig<MainViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_main, MainViewModel.class, BR.viewModel);
    }
}
