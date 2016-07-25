package io.blackbricks.bricktemplate.ui.main;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import io.blackbricks.bricktemplate.BR;
import io.blackbricks.bricktemplate.R;
import io.blackbricks.bricktemplate.databinding.ActivityMainBinding;

public class MainActivity extends ViewModelActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public ViewModelBindingConfig<MainViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_main, MainViewModel.class, BR.viewModel);
    }
}
