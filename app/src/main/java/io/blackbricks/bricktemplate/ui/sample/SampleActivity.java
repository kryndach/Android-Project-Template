package io.blackbricks.bricktemplate.ui.sample;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import io.blackbricks.bricktemplate.BR;
import io.blackbricks.bricktemplate.R;
import io.blackbricks.bricktemplate.databinding.ActivitySampleBinding;

public class SampleActivity extends ViewModelActivity<ActivitySampleBinding, SampleViewModel> {


    @Override
    public ViewModelBindingConfig<SampleViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_sample, SampleViewModel.class, BR.viewModel);
    }
}
